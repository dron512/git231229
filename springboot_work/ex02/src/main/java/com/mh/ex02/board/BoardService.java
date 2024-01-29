package com.mh.ex02.board;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    @Value("${aa}")
    private String aa;

    @Value("${bb}")
    private String bb;

    @Autowired
    BoardDao boardDao;

    public List<BoardDto> getAll(){
        System.out.println(aa);
        System.out.println(bb);

        return boardDao.getAll();
    }
}
