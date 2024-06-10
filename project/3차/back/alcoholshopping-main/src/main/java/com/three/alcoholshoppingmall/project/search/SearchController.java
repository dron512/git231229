package com.three.alcoholshoppingmall.project.search;

import com.p6spy.engine.logging.Category;
import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholRepository;
import com.three.alcoholshoppingmall.project.alcohol.MainListDto;
import com.three.alcoholshoppingmall.project.exception.BizException;
import com.three.alcoholshoppingmall.project.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.three.alcoholshoppingmall.project.exception.ErrorCode.*;

@RestController
@RequestMapping("/search")
@Tag(name = "SearchController", description = "주류 검색")
@RequiredArgsConstructor
@ToString

public class SearchController {

    private final AlcoholRepository alcoholRepository;
    private final SearchService searchService;


    @GetMapping("/category")
    @Operation(summary = "category로 주류 검색", description = "maincategory나 subcategory로 주류 검색")
    public ResponseEntity<List<MainListDto>> category(@RequestParam String category) {
        List<Alcohol> alcoholList = alcoholRepository.findBySubcategoryOrMaincategory(category, category);
        if (alcoholList.isEmpty()) {
            throw new BizException(NULLCATEGORY);
        } else {
            List<MainListDto> list = new ArrayList<>();
            for (Alcohol alcohol : alcoholList) {
                MainListDto mainListDto = MainListDto.builder()
                        .code(alcohol.getCode())
                        .name(alcohol.getName())
                        .price(alcohol.getPrice())
                        .ratingaverage(alcoholRepository.Rating(alcohol.getCode()))
                        .picture(alcohol.getPicture())
                        .build();
                list.add(mainListDto);
            }
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
    }

}