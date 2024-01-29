package com.mh.ex04.board;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("list")
    public String list(Model model){
        List<Board> list = boardRepository.list();
        model.addAttribute("list",list);
        return "board/list";
    }

    @GetMapping("writeform")
    public String writeform(Model model, BoardReq boardReq){
        model.addAttribute("first","true");
        return "board/writeform";
    }

    @PostMapping("writeproc")
    public String writeproc(Model model, @Valid BoardReq boardReq, BindingResult result){
        if( result.hasErrors()){
            return "board/writeform";
        }
        System.out.println(boardReq);
        /* 저장하는 부분 시작 */
        Board board = Board.builder()
                .content(boardReq.getContent())
                .title(boardReq.getTitle())
                .name(boardReq.getName())
                .build();
        boardRepository.insert(board);
        /* 저장하는 부분 끝 */
        return "redirect:/board/list";
    }

}
