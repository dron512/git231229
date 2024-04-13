package com.mh.mychart.item;

import com.mh.mychart.item.dto.ItemDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

@RequestMapping("/api/item")
@RequiredArgsConstructor
@RestController
@SecurityRequirement(name = "Bearer Authentication")
public class ItemController {

    private final ItemService itemService;

    @PostMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public EntityModel<ItemDto> handleFileUpload(@RequestPart(value = "file", required = true) MultipartFile[] file,
                                                 @RequestPart(value = "itemDto", required = false) ItemDto itemDto,
                                                 Principal principal){

        System.out.println(itemDto);
        System.out.println(principal.getName());

        if (file[0].isEmpty()) {
            return EntityModel.of(ItemDto.builder()
                    .name("file upload failed because file is empty")
                    .build());
        }

        itemService.save(itemDto, file);

        EntityModel<ItemDto> entityModel = EntityModel.of(itemDto);
        return entityModel;
    }

//    @GetMapping("/{fileName:.+}")
//    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
//        Path filePath = this.imageStorageLocation.resolve(fileName).normalize();
//        Resource resource;
//        try {
//            resource = (Resource) new UrlResource(filePath.toUri());
//            return ResponseEntity.ok()
//                    //.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                    .body(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.notFound().build();
//        }
//    }
}
