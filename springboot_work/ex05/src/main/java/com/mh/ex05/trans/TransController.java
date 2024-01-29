package com.mh.ex05.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("trans")
public class TransController {

    @Autowired
    TransService transService;

    @Autowired
    TransRepository transRepository;

    @GetMapping("trans")
    public String trans(Model model){

        List<Trans> list = transRepository.findAll(Sort.by(Sort.Direction.DESC,"idx"));
        model.addAttribute("list",list);

        return "trans/trans";
    }

    @PostMapping("req")
    @ResponseBody
    public String req(@RequestBody TranslationJson translationJson){
        String target = transService.main(translationJson.getText());

        transRepository.save(Trans.builder()
                        .source(translationJson.getText())
                        .target(target)
                        .build());

        return target;
    }
}
