package com.mh.ex03.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

//    @Autowired
//    BoardDao boardDao;

    @Autowired
    BoardRepository boardRepository;

    public List<BoardDto> list(){
        return boardRepository.list();
    }

}
