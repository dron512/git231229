package com.mh.fileex.user;

import com.mh.fileex.file.FileController;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final Path imagePath;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.imagePath = Paths.get("src/main/resources/static/images/upload/")
                            .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.imagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void join(User user, MultipartFile imageFile) {
        try {
            // 저장...
            File dest = new File(imagePath +
                    "/" + imageFile.getOriginalFilename());
            imageFile.transferTo(dest);
        }catch (Exception e){
            // 만약 디스크 저장에 실패하면 DB에 저장하지 않는다.
            e.printStackTrace();
            return;
        }
        Link link = WebMvcLinkBuilder
                .linkTo(
                        WebMvcLinkBuilder
                                .methodOn(FileController.class)
                                .getImage(imageFile.getOriginalFilename())
                )
                .withRel("download");

        // D: 드라이브에 저장
//        user.setImagePath(imagePath + "/" + imageFile.getOriginalFilename());
        // http://localhost:8080/api/file/download/파일이름
        user.setImagePath(link.getHref().toString());

        // 디스크에 파일 저장시 user 저장..
        userRepository.save(user);

    }


    public String loginCheck(UserDto userDto) {

        Optional<User> optionalUser = userRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());

        if(optionalUser.isPresent()) {
            return "loginok";
        }
        else{
            return "loginfail";
        }
    }
}

















