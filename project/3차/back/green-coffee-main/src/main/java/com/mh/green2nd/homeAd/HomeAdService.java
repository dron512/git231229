// HomeAdService.java

package com.mh.green2nd.homeAd;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HomeAdService {

    private final HomeAdRepository homeAdRepository;

    // 이벤트 홈 광고
    public List<HomeAd> getEvent() {
        LocalDateTime now = LocalDateTime.now();
        return homeAdRepository.findByAdDueDateAfter(now).stream()
                .filter(homeAd -> homeAd.getAdHead().contains("이벤트"))
                .collect(Collectors.toList());
    }

}
