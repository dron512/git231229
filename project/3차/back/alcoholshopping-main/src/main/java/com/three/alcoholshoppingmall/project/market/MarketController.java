package com.three.alcoholshoppingmall.project.market;


import com.three.alcoholshoppingmall.project.alcohol.AlcoholDto;
import com.three.alcoholshoppingmall.project.alcohol.Alcoholmain;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("market")
@RequiredArgsConstructor
@Tag(name = "MarketController",description = "마켓 정보")
public class MarketController {

    private final MarketRepository marketRepository;
    private final MarketService marketService;

    @GetMapping("address")
    @Operation(summary = "전체 마켓 목록")
    public ResponseEntity<List<Market>> marketAddress(){
        List<Market> market = marketRepository.findAll();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(market);
    }
    @PostMapping("")
    @Operation(summary = "해당 술을 파는 매장",
            description = "술의 code를 입력 하시면 해당 술을 파는 매장을 보여줍니다" +
                    "code는 1~50까지 있습니다")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Market>> Market(@RequestBody AlcoholDto alcoholDto){

List<Market> list = marketService.Marketlist(alcoholDto.getCode());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
    }







}
