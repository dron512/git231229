package com.example.mateproject.controller;

import com.example.mateproject.dao.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class StatusController {

    @Autowired
    StatusRepository statusRepository;

    @GetMapping("/status")
    public String status(Model model) throws IOException {
        model.addAttribute("status",statusRepository.doSelect());
        return "status";
    }





}
