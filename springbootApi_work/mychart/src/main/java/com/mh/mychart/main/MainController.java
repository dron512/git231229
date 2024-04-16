package com.mh.mychart.main;

import com.mh.mychart.item.ItemDto;
import com.mh.mychart.kakao.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final KakaoService kakaoService;

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

    @GetMapping("oauth/kakao/callback")
    public String kakaoCallback(String code){
        kakaoService.getKakaoToken(code);
        String redirectTo = "http://localhost:3000?accessToken=asdfasdf&refeshToken=asdcflkjqnwc"; // 클라이언트 주소

        return "redirect:" + redirectTo;
    }

}











