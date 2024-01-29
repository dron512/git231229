package com.mh.ex04.board;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("boardapi")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardRepository boardRepository;

    @GetMapping("list")
    public ResponseEntity<List<Board>> list(){
        List<Board> list = boardRepository.list(1);
        return ResponseEntity.ok(list);
    }


}
