package com.mh.ex05.guestbook;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("guestbookapi")
public class GuestBookApiController {

    private GuestBookRepository guestBookRepository;

    @GetMapping("list")
    public ResponseEntity<List<GuestBook>> list(){
        List<GuestBook> list = guestBookRepository.findAll();
        return ResponseEntity.ok(list);
    }

}
