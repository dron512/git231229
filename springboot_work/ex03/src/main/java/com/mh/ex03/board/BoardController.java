package com.mh.ex03.board;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("list")
    public String list(Model model) {
        List<BoardDto> list = boardService.list();
        model.addAttribute("list", list);
        return "board/list";
    }

    @GetMapping("writeform")
    public String writeform(Model model,
                            BoardReq boardReq,
                            BindingResult result) {
        model.addAttribute("first","true");
        return "board/writeform";
    }

    @PostMapping("writeproc")
    public String writeproc(@Valid BoardReq boardReq, BindingResult result) {

        if(result.hasErrors()){
            System.out.println("에러 있음");
            System.out.println(result);
            return "board/writeform";
        }
        // 디비 저장
        System.out.println("boardReq " + boardReq);
        return "redirect:/board/list";
    }
}



















