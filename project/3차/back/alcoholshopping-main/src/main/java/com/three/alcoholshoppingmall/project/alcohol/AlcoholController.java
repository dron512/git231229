package com.three.alcoholshoppingmall.project.alcohol;

import com.three.alcoholshoppingmall.project.user.User;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("alcohol")
@Tag(name = "alcohol", description = "알콜 정보 출력 페이지 입니다.")
public class AlcoholController {

    private final AlcoholService alcoholService;
    @PostMapping("/main")
    @Operation(summary = "메인 카테고리를 정렬하는 기능 입니다.",
            description = "Type에 인기, 높은 가격, 낮은 가격이라 입력 받으면" +
                    "maincategory의 정렬을 바꾸어 줍니다.")
    public ResponseEntity<List<Alcoholmain>> MainOrder(@RequestBody SortDTO sortDTO) {

        List<Alcoholmain> list = alcoholService.MainType(sortDTO.getMaincategory(), sortDTO.getType());

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/sub")
    @Operation(summary = "서브 카테고리를 정렬하는 기능 입니다.",
            description = "Type에 인기, 높은 가격, 낮은 가격이라 입력 받으면" +
                    "subcategoryy의 정렬을 바꾸어 줍니다.")

    public ResponseEntity<List<Alcoholmain>> SubOrder(@RequestBody SortDTO sortDTO) {

        List<Alcoholmain> list = alcoholService.SubType(sortDTO.getSubcategory(), sortDTO.getType());

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }



}
