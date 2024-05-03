package com.mh.mychart.item;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("api/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping(value = "/new",
                                    produces = MediaType.APPLICATION_JSON_VALUE,
                                    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> newItem(
        @Valid @RequestPart ItemDto itemDto,
        @RequestPart("files") MultipartFile[] files
        ) throws IOException {

        if(files[0] == null)
            return  ResponseEntity
                    .status( HttpStatus.NOT_ACCEPTABLE )
                    .body( "상품 이미지를 한 개 등록하세요");

        boolean result = itemService.addItem(itemDto,files);

        if(result)
            return ResponseEntity
                    .status( HttpStatus.OK )
                    .body( "저장하였습니다.");
        else
            return ResponseEntity
                    .status( HttpStatus.NOT_ACCEPTABLE )
                    .body( "중복입니다..");
    }


    // 유효성 검사랑, 아이템 수정 처리 해야함.
    // baseEntity로 시간 넣어야함.

    @GetMapping("download/{fileName}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName){
        Path imagesStorageLocation = Paths.get("images/item").toAbsolutePath().normalize();
        try{
            Path filePath = imagesStorageLocation.resolve(fileName);
            Resource resource = new UrlResource(filePath.toUri());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        }catch (IOException e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("list")
    public ResponseEntity<List<ItemResDto>> getItemList(){
        List<ItemResDto> list = itemService.listItem();
        return ResponseEntity.ok(list);
    }

}








