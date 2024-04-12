package com.mh.mychart.main;

import com.mh.mychart.item.ItemDto;
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
                    new ItemDto("아메리카노",2000),
                    new ItemDto("카페라떼",3000),
                    new ItemDto("카푸치노",3500)
                );
        model.addAttribute("list",list);
        return "container";
    }
}
