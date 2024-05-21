package com.mh.green2nd.recommend;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/recommend")
@RestController
public class RecommendController {
    private final RecommendService recommendService;

    @GetMapping("/")
    public ResponseEntity<List<RecommendDto>> getRecommendations() {
        List<RecommendDto> recommendDtoList = recommendService.getRecommendations();
        return ResponseEntity.status(HttpStatus.OK).body(recommendDtoList);
    }
}
