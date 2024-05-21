package com.mh.green2nd.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<Menu> coffee() {
        return menuRepository.findByCategory("coffee");
    }
    public List<Menu> beverage() {
        return menuRepository.findByCategory("beverage");
    }
    public List<Menu> food() {
        return menuRepository.findByCategory("food");
    }
    public List<Menu> goods() {
        return menuRepository.findByCategory("goods");
    }



    public List<Menu> detail(String name) {
        return menuRepository.detail(name);
    }



    public List<Menu> search(String name) {
        return menuRepository.findByNameContaining(name);
    }



}
