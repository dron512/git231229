package com.mh.mychart.item;

import com.mh.mychart.item.Entity.Item;
import com.mh.mychart.item.Entity.ItemImg;
import com.mh.mychart.item.dto.ItemDto;
import com.mh.mychart.member.Member;
import com.mh.mychart.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
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
                itemImgRepository.save(ItemImg.builder()
                        .item(item)
                        .imgUrl(filePath)
                        .build());
            }
            EntityModel<ItemDto> entityModel = EntityModel.of(ItemDto.builder()
                    .name("file upload success")
                    .build());
//            entityModel.add(WebMvcLinkBuilder.linkTo(
//                            WebMvcLinkBuilder.methodOn(ItemController.class).getImage(fileName))
//                    .withRel("file"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}