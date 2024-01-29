package com.mh.ex02.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("data1","한글");
        model.addAttribute("data2","eng");
        model.addAttribute("myData","myValue");

        List<BoardDto> list = boardService.getAll();
        model.addAttribute("list",list);

        return "index";
    }

}
