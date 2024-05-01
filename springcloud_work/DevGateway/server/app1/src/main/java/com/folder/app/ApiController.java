package com.folder.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ApiController {

  @GetMapping("/api1/test")
  public String test() {
    log.info("App1 - Test()");
    return "App1 - Test()";
  }

}
