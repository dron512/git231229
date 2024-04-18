package com.mh.mychart.item;

import com.mh.mychart.item.dto.ItemDto;
import com.mh.mychart.item.dto.ItemImgDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class ItemController {

    private final ItemService itemService;

    @PostMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public EntityModel<ItemImgDto> handleFileUpload(@RequestPart(value = "files", required = true) MultipartFile[] file,
                                                 @RequestPart(value = "itemDto", required = false) ItemDto itemDto,
                                                 Principal principal){

        System.out.println(itemDto);
        System.out.println(principal.getName());

        if (file[0].isEmpty()) {
            return EntityModel.of(null);
        }

        EntityModel<ItemImgDto> entityModel = itemService.save(itemDto, file);

        return entityModel;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable Long id){
        ItemDto itemDto = itemService.getItem(id);
        return ResponseEntity.ok(itemDto);
    }


}
