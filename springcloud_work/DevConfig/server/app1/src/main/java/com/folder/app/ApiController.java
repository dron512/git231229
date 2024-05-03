package com.folder.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RefreshScope
@Slf4j
@RestController
public class ApiController {

  @Value(value = "${user.message}")
  private String message;

  @GetMapping("/")
  public String test() {
    log.info("App1 - Test()");

    log.info("message : {}", message);

    return "App1 - Test()";
  }

}
