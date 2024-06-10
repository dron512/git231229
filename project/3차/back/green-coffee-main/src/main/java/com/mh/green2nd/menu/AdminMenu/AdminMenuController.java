package com.mh.green2nd.menu.AdminMenu;

import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/menu")
public class AdminMenuController {

    private final AdminMenuService adminMenuService;

    // admin만 메뉴 조회 가능
    @Operation(summary = "메뉴 조회", description = "admin만 메뉴 조회 가능")
    @GetMapping("/list")
    public List<AdminMenuGetDto> getMenuList(Authentication authentication) {
        User jwtuser = (User) authentication.getPrincipal();
        return adminMenuService.getMenuList(jwtuser);
    }

    // admin만 메뉴 상태 수정 가능
    @Operation(summary = "메뉴 상태 수정", description = "0: 품절, 1: 판매중")
    @PutMapping("/{menuId}/status")
    public  ResponseEntity<String> updateMenuStatus(Authentication authentication, @PathVariable Long menuId, @RequestBody boolean status) {
        User jwtuser = (User) authentication.getPrincipal();
        adminMenuService.updateMenuStatus(jwtuser, menuId, status);
        return ResponseEntity.ok("메뉴 상태가 수정되었습니다.");
    }

}