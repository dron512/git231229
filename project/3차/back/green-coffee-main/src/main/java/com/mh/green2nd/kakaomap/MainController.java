package com.mh.green2nd.kakaomap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("page", 1);
        model.addAttribute("perPage", 10);
        return "kakaomap";
    }

    @PostMapping("/")
    public String index(@RequestParam(defaultValue = "1") int page,
                        @RequestParam(defaultValue = "10") int perPage,
                        Model model) throws IOException {

        ResponseData data = mainService.test(page, perPage);
        model.addAttribute("result", data);
        return "kakaomap";
    }

}
