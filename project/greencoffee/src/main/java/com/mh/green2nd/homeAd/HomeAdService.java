// HomeAdService.java

package com.mh.green2nd.homeAd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeAdService {

    @Autowired
    private HomeAdRepository homeAdRepository;

    public List<HomeAdDTO> getAdvertisementsByCategory(HomeAdCategory category) {
        List<HomeAd> advertisements = homeAdRepository.findByCategory(category);
        // Entity를 DTO로 변환하여 반환
        return advertisements.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private HomeAdDTO convertToDto(HomeAd entity) {
        HomeAdDTO dto = new HomeAdDTO();
        dto.setAdHead(entity.getAdHead());
        dto.setAdContent(entity.getAdContent());
        dto.setImageUrl(entity.getImageUrl()); // 이미지 URL 설정
        dto.setAdUploadTime(entity.getAdUploadTime());
        dto.setAdDueDate(entity.getAdDueDate());
        return dto;
    }
}
