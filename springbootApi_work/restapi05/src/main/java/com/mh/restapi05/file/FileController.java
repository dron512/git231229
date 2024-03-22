package com.mh.restapi05.file;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequestMapping("/file")
@RequiredArgsConstructor
@RestController
public class FileController {

    private final Path imageStorageLocation;

    public FileController() {
        // 이미지 업로드 경로 설정
        this.imageStorageLocation = Paths.get("image/file/").toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.imageStorageLocation);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @PostMapping("/upload")
    public EntityModel<FileDto> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return EntityModel.of(new FileDto("파일을 선택해주세요."));
        }
        try {
            // 업로드된 파일을 저장
            String fileName = file.getOriginalFilename();
            String filePath = imageStorageLocation + "/"+ fileName;
            File dest = new File(filePath);
            file.transferTo(dest);

            EntityModel<FileDto> entityModel = EntityModel.of(new FileDto("file uploaded successfully"));
            entityModel.add(WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(FileController.class).getImage(fileName))
                    .withRel("file"));
            return entityModel;
        } catch (IOException e) {
            e.printStackTrace();
            return EntityModel.of(new FileDto("file upload failed"));
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
