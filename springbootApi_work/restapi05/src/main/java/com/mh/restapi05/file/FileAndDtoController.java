package com.mh.restapi05.file;

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

@RequestMapping("/filedto")
@RequiredArgsConstructor
@RestController
@SecurityRequirement(name = "Bearer Authentication")
public class FileAndDtoController {

    private final Path imageStorageLocation;

    public FileAndDtoController() {
        // 이미지 업로드 경로 설정
        this.imageStorageLocation = Paths.get("image/file/").toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.imageStorageLocation);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @PostMapping(value = "/upload",produces=MediaType.APPLICATION_JSON_VALUE,
                                        consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public EntityModel<FileDto> handleFileUpload(@RequestPart(value="file", required=true) MultipartFile file,
                                                 @RequestPart(value="key",required = false) FileDto fileDto){
        System.out.println(fileDto);
        if (file.isEmpty()) {
            return EntityModel.of(new FileDto("파일을 선택해주세요.",null,null));
        }
        try {
            // 업로드된 파일을 저장
            String fileName = file.getOriginalFilename();
            String filePath = imageStorageLocation + "/"+ fileName;
            File dest = new File(filePath);
            file.transferTo(dest);

            EntityModel<FileDto> entityModel = EntityModel.of(new FileDto("file uploaded successfully",null,null));
            entityModel.add(WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(FileAndDtoController.class).getImage(fileName))
                    .withRel("file"));
            return entityModel;
        } catch (IOException e) {
            e.printStackTrace();
            return EntityModel.of(new FileDto("file upload failed",null,null));
        }
    }

    @GetMapping("/{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
        Path filePath = this.imageStorageLocation.resolve(fileName).normalize();
        Resource resource;
        try {
            resource = new UrlResource(filePath.toUri());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                //.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
