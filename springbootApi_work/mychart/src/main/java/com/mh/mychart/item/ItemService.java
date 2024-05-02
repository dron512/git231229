package com.mh.mychart.item;

import com.mh.mychart.item.itemimg.ItemImg;
import com.mh.mychart.item.itemimg.ItemImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemImgRepository itemImgRepository;
    private final Path imageStorageLocation;

    public ItemService(ItemRepository itemRepository, ItemImgRepository itemImgRepository) {
        this.itemRepository = itemRepository;
        this.itemImgRepository = itemImgRepository;
        this.imageStorageLocation = Paths.get("images/item").toAbsolutePath().normalize();
        try{
            Files.createDirectories(this.imageStorageLocation);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(imageStorageLocation);
    }

    public void addItem(ItemDto itemDto, MultipartFile[] files) throws IOException {

//        Item item = new ModelMap
        Item item = Item.builder()
                .price(itemDto.getPrice())
                .name(itemDto.getItemNm())
                .build();
        // 하나 생성
        Item dbItem = itemRepository.save(item);

        for(MultipartFile file:files){
            // 파일 경로와 파일 이름 생성
            String fileName = file.getOriginalFilename();
            String filePath = imageStorageLocation +"/"+fileName;
            // 파일 저장 images/item
            File dest = new File(filePath);
            file.transferTo(dest);
            
            // Itemimg 행저장
            ItemImg itemImg = ItemImg.builder()
                    .item(dbItem)
                    .imgPath(fileName)
                    .build();
            itemImgRepository.save(itemImg);
        }

    }
}
