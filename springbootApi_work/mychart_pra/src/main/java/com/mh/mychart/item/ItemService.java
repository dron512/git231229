package com.mh.mychart.item;

import com.mh.mychart.item.Entity.Item;
import com.mh.mychart.item.Entity.ItemImg;
import com.mh.mychart.item.dto.ItemDto;
import com.mh.mychart.item.dto.ItemImgDto;
import com.mh.mychart.member.Member;
import com.mh.mychart.member.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private final ItemImgRepository itemImgRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final Path imageStorageLocation;

    public ItemService(ItemImgRepository itemImgRepository, ItemRepository itemRepository, MemberRepository memberRepository) {
        this.itemImgRepository = itemImgRepository;
        this.itemRepository = itemRepository;
        this.memberRepository = memberRepository;
        this.imageStorageLocation = Paths.get("image/file/").toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.imageStorageLocation);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    public String save(ItemDto itemDto, MultipartFile[] file){

        Long memberId = ((Member)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getMemberId();

        itemDto.setMember(memberRepository.findById(memberId).get());
        Item item = itemRepository.save(itemDto.toEntity());

        try {
            // 업로드된 파일을 저장
            for(MultipartFile f : file){
                String fileName = f.getOriginalFilename();
                String filePath = imageStorageLocation + "/" + fileName;
                File dest = new File(filePath);
                f.transferTo(dest);

                EntityModel<ItemImgDto> entityModel = EntityModel.of(ItemImgDto.builder()
                        .imgUrl(filePath)
                        .build());

                EntityModel<ItemImgDto> link =  entityModel.add(WebMvcLinkBuilder.linkTo(
                                WebMvcLinkBuilder.methodOn(ImgFileController.class).getImage(fileName))
                        .withRel("file"));
                System.out.println(link);

                itemImgRepository.save(ItemImg.builder()
                        .item(item)
                        .imgName(fileName)
                        .imgUrl(link.getLinks().toList().get(0).getHref())
                        .build());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }

        return "success";
    }

    public ItemDto getItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(
                ()->new RuntimeException("item is Empty"));

        List<ItemImgDto> itemImgDtoList = new ArrayList<>();
        for(ItemImg itemImg : item.getItemImgList()){
            itemImgDtoList.add(ItemImgDto.builder()
                    .imgName(itemImg.getImgName())
                    .imgUrl(itemImg.getImgUrl())
                    .build());
        }

        return ItemDto.builder()
                .id(item.getItemId())
                .name(item.getItemNm())
                .description(item.getDescription())
                .price(item.getPrice())
                .stock(item.getStock())
                .itemImgDtoList(itemImgDtoList)
                .member(item.getMember())
                .build();
    }
}