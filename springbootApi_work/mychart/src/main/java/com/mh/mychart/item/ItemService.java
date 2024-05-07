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
import java.util.List;
import java.util.Optional;

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

    public boolean addItem(ItemDto itemDto, MultipartFile[] files) throws IOException {
        Optional<Item> dbItem = itemRepository.findByName(itemDto.getItemNm());
        if(dbItem.isPresent()){
            return false;
        }
        if(dbItem.isEmpty()) {
            Item item = Item.builder()
                    .price(itemDto.getPrice())
                    .name(itemDto.getItemNm())
                    .build();

            Item insertedItem = itemRepository.save(item);

            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                String filePath = imageStorageLocation + "/" + fileName;
                File dest = new File(filePath);
                file.transferTo(dest);

                ItemImg itemImg = ItemImg.builder()
                        .item(insertedItem)
                        .imgPath(fileName)
                        .build();
                itemImgRepository.save(itemImg);
            }
        }
        return true;
    }


    public List<ItemResDto> listItem() {
        List<ItemResDto> list = itemRepository.getItemList();
        return list;
    }
}















