package com.green.onezo.store;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepostitory storeRepostitory;

    // 매장상세 조회
    public StoreDto getStoreById(Long storeId) {
        Store store = storeRepostitory.findById(storeId)
                .orElseThrow(() -> new EntityNotFoundException("스토어아이디?" + storeId));

        return StoreDto.builder()
                .storeName(store.getStoreName())
                .address(store.getAddress())
                .storePhone(store.getStorePhone())
                .openTime(store.getOpenTime())
                .closeTime(store.getCloseTime())
                .storeStatus(store.getStoreStatus())
                .build();
    }
}
