package com.mh.mychart.main;

import com.mh.mychart.item.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/container")
    public String container(Model model){
        List<ItemDto> list =
                Arrays.asList(
                        ItemDto.builder().id(1L).name("테스트1").description("테스트1입니다.").price(1000).stock(10).build(),
                        ItemDto.builder().id(2L).name("테스트2").description("테스트2입니다.").price(2000).stock(20).build(),
                        ItemDto.builder().id(3L).name("테스트3").description("테스트3입니다.").price(3000).stock(30).build()
                );
        model.addAttribute("list",list);
        return "container";
    }
}
