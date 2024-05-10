package com.mh.mychart.item;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemRepositoryCustom {
    public List<ItemResDto> getItemList();

    public List<ItemResDto> getItemListlazy();
}
