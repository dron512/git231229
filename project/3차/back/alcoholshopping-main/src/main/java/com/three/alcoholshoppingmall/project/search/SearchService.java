package com.three.alcoholshoppingmall.project.search;

import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholRepository;
import com.three.alcoholshoppingmall.project.alcohol.MainListDto;
import com.three.alcoholshoppingmall.project.exception.BizException;
import com.three.alcoholshoppingmall.project.user.User;
import com.three.alcoholshoppingmall.project.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.three.alcoholshoppingmall.project.exception.ErrorCode.*;


@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository searchRepository;
    private final AlcoholRepository alcoholRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<MainListDto> memberSearch(String searchcontents, String email) {
        List<Double> ratings =
                alcoholRepository.RatingList("%" + searchcontents + "%");
        List<Alcohol> list =
                alcoholRepository.findByNameContaining(searchcontents);
        searchRepository.searchsave(email, searchcontents);
        if (searchcontents.isEmpty()) {
            throw new BizException(NULLSEARCH);
        }
        if (list.isEmpty()) {
            throw new BizException(NOTFOUNDALCOHOL);
        }
        if (searchcontents.length() <= 1) {
            throw new BizException(SEARCHCLENGTH);
        } else {
            List<MainListDto> searchDetails = new ArrayList<>();
            for (int i = 0; i < ratings.size(); i++) {
                Alcohol alcohol = list.get(i);
                MainListDto mainListDto = MainListDto.builder()
                        .code(alcohol.getCode())
                        .name(alcohol.getName())
                        .price(alcohol.getPrice())
                        .picture(alcohol.getPicture())
                        .ratingaverage(ratings.get(i))
                        .build();
                searchDetails.add(mainListDto);
            }
            return searchDetails;
        }
    }

    public List<String> recentSearch(String email) {
        User dbUser = userRepository.findByEmail(email);
        if (dbUser == null){
            throw new BizException(NOTFOUNDUSER);
        }
        List<String> list = searchRepository.findAllByUserOrderByIdDesc(email);
        if (list.isEmpty()) {
            throw new BizException(NULLRECENT);
        } else {
            return list;
        }
    }


}