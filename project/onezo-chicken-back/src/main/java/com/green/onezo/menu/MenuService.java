package com.green.onezo.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public Menu menuView(Long id) {
        return menuRepository.findById(id).get();
    }

    public List<Menu> allMenuView() {
        return menuRepository.findAll();
    }

    
}
