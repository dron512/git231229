package com.folder.app.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
public class JwtController {

  @Autowired private JwtComponent jwtComponent;

  @GetMapping("/auth/authorize")
  public Map<String, Object> authorize(@RequestParam("name") String name) {
    return jwtComponent.setJwtToken(name);
  }

  @PostMapping("/auth/verification")
  public Map<String, Object> verification(HttpServletRequest request) {
    return jwtComponent.getJwtInfo(request);
  }

}
