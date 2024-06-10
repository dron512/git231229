package com.three.alcoholshoppingmall.project.main;


import com.three.alcoholshoppingmall.project.alcohol.AlcoholDto;
import com.three.alcoholshoppingmall.project.alcohol.Alcoholmain;
import com.three.alcoholshoppingmall.project.alcohol.Eventservice;
import com.three.alcoholshoppingmall.project.alcohol.MainListDto;
import com.three.alcoholshoppingmall.project.login.LoginService;
import com.three.alcoholshoppingmall.project.market.MarketService;
import com.three.alcoholshoppingmall.project.search.MemberSearchDto;
import com.three.alcoholshoppingmall.project.search.NoneMemberSearchDto;
import com.three.alcoholshoppingmall.project.search.Search;
import com.three.alcoholshoppingmall.project.search.SearchService;
import com.three.alcoholshoppingmall.project.user.User;
import com.three.alcoholshoppingmall.project.user.UserSub;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("main")
@Tag(name = "main", description = "메인페이지 입니다.")
public class MainConstructor {

    private final Eventservice eventservice;
    private final MarketService marketService;
    private final SearchService searchService;
    private final LoginService loginService;


    @GetMapping("/most")
    @Operation(summary = "주간 많이 팔린 제품",
            description = "주간 많이 팔린 술 3개를 보여 줍니다." +
                    "입력 값은 없습니다.")
    public ResponseEntity<List<Alcoholmain>> Mostsold() {
        List<Alcoholmain> list = eventservice.Most();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/rand")
    @Operation(summary = "랜덤 3개",
            description = "랜덤으로 3개의 제품을 보여줍니다. ")
    public ResponseEntity<List<Alcoholmain>> RAND() {
        List<Alcoholmain> list = eventservice.Rand();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/newproduct")
    @Operation(summary = "신 제품",
            description = "가장 최근에 나온 제품을 보여 줍니다." +
                    "입력 값은 없습니다.")
    public ResponseEntity<List<Alcoholmain>> NewProduct() {
        List<Alcoholmain> list = eventservice.Product();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/delivery")
    @Operation(summary = "배달 배송을 하는 매장의 판매 물품",
            description = "입력 값은 따로 없습니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Alcoholmain>> DeliveryMarket() {
        String type = "Delivery";
        List<Alcoholmain> list = marketService.DeliveryPickup(type);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
    }

    @GetMapping("/pickup")
    @Operation(summary = "픽업 하는 매장의 판매 물품",
            description = "입력 값은 따로 없습니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Alcoholmain>> PickupMarket() {
        String type = "pickup";
        List<Alcoholmain> list = marketService.DeliveryPickup(type);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
    }

    @PostMapping("/contents") // 회원 검색
    @Operation(summary = "회원일 때 검색, name으로 주류를 검색",
            description = "회원이 검색하는 기능입니다. <br>" +
                    "searchcontents에 name으로 주류를 검색하는 기능입니다. <br>" +
                    "단어를 완성하지 않아도 내용이 나오게 만들었습니다. <br>" +
                    "회원 이메일에는 aaa@naver.com, bbb@naver.com, ccc@naver.com이 있습니다. <br>" +
                    "searchcontents에 입력값이 필요합니다." +
                    "메인페이지에서 검색창에 검색을 하면 검색 기록과 회원의 이메일이 db에 저장됩니다. <br>" +
                    "검색창이 비어 있으면 NULLSEARCH, 검색기록은 공백일 수 없습니다라고 에러 코드가 뜹니다.<br>" +
                    "db에 저장되어 있는 주류외에 다른 주류 이름을 검색하거나 오타로 검색을 하면 NOTFOUNDALCOHOL<br>," +
                    "해당 이름의 주류를 찾을 수 없습니다라고 에러 코드가 뜹니다.<br>" +
                    "검색창에 한글자로 검색을 하면 SEARCHLENGTH, 검색 기록은 두 글자 이상 입력해야합니다라고 에러코드가 뜹니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<MainListDto>> memberSearch
            (@RequestBody MemberSearchDto memberSearchDto) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String email = user.getEmail();
        List<MainListDto> list = searchService.memberSearch
                (memberSearchDto.getSearchcontents(), email);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/anony/contents")
    @Operation(summary = "비회원일 때 검색, name으로 주류를 검색",
            description = "비회원이 검색하는 기능입니다.<br>" +
                    "searchcontents에 name으로 주류를 검색하는 기능입니다.<br>" +
                    "단어를 완성하지 않아도 검색이 가능합니다.<br>" +
                    "비회원 이메일은 anony@anony.anony입니다.<br>" +
                    "searchcontents에 입력값이 필요합니다.<br>" +
                    "메인페이지에서 검색창에 검색을 하면 검색 기록과 비회원의 이메일이 db에 저장됩니다.<br>" +
                    "검색창이 비어 있으면 NULLSEARCH, 검색기록은 공백일 수 없습니다라고 에러 코드가 뜹니다.<br>" +
                    "db에 저장되어 있는 주류외에 다른 주류 이름을 검색하거나 오타로 검색을 하면 NOTFOUNDALCOHOL<br>," +
                    "해당 이름의 주류를 찾을 수 없습니다라고 에러 코드가 뜹니다.<br>" +
                    "검색창에 한글자로 검색을 하면 SEARCHLENGTH, 검색 기록은 두 글자 이상 입력해야합니다라고 에러코드가 뜹니다.")
    public ResponseEntity<List<MainListDto>> NonmemberSearch
            (@RequestBody NoneMemberSearchDto noneMemberSearchDto) {
        String email = "anony@anony.anony";
        List<MainListDto> list = searchService.memberSearch
                (noneMemberSearchDto.getSearchcontents(), email);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


    @GetMapping("/recent")
    @Operation(summary = "회원의 최근 검색기록",
            description = "회원의 최근 검색 기록을 5개 출력하게 만들었습니다. <br>" +
                    "검색창에 검색 시 회원의 최근 검색 기록 5개를 뜨게 하는 기능입니다. <br>" +
                    "입력 값은 필요 없습니다.<br>" +
                    "검색을 하면서 db에 저장되었던 내용을 최신순으로 5개를 출력하게 하는 기능입니다. <br>" +
                    "비회원의 검색기록이 없으면 NULLRECENT 에러코드가 나오며, 최근 검색기록이 존재하지 않습니다라고 에러 메시지가 나옵니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Search>> recent() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        System.out.println(user.getEmail());
        String email = user.getEmail();
        List<String> list = searchService.recentSearch(email);
        List<Search> searchList = list.stream().map(
                        item -> Search.builder()
                                .searchcontents(item)
                                .build())
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(searchList);
    }


    @GetMapping("/user")
    @Operation(summary = "회원의 닉네임 주소",
            description = "회원의 닉네임과 주소와 상세 주소가 보입니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<UserSub>> User() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String email = user.getEmail();
        List<UserSub> list = loginService.SUB(email);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}