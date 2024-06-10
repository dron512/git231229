package com.mh.green2nd.store.adminStore;

import com.mh.green2nd.store.StoreDto;
import com.mh.green2nd.store.StoreInfo;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/store")
@RequiredArgsConstructor
public class AdminStoreController {
    private final AdminStoreService adminStoreService;

//    // admin는 자신이 속한 매장 조회 가능
//    @Operation(summary = "매장 조회", description = "admin은 자신이 속한 매장 조회 가능")
//    @GetMapping("/store")
//    public ResponseEntity<StoreInfo> getStoreDetails(Authentication authentication) {
//        User currentUser = (User) authentication.getPrincipal();
//        StoreInfo storeInfo = adminStoreService.getStoreInfo(currentUser);
//        return ResponseEntity.ok(storeInfo);
//    }

    // admin만 매장 영업시간 수정 가능
    @Operation(summary = "매장 영업시간 수정", description = "admin만 매장 영업시간 수정 가능, name은 매장 이름(대구점, 서울점, 부산점, 인천점, 대전점)")
    @PutMapping("/{name}/time/{open}/{close}")
    public ResponseEntity<String> updateStoreTime(@PathVariable String name, @PathVariable String open, @PathVariable String close, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        adminStoreService.updateStoreTime(currentUser, name, open, close);
        return ResponseEntity.ok("매장 영업시간이 수정되었습니다.");
    }

    // admin만 휴무일 수정 가능
    @Operation(summary = "매장 휴무일 수정", description = "admin만 휴무일 수정 가능, name은 매장 이름(대구점, 서울점, 부산점, 인천점, 대전점)")
    @PutMapping("/{name}/holiday")
    public ResponseEntity<String> updateStoreHoliday(@PathVariable String name, @RequestBody String holiday, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        adminStoreService.updateStoreHoliday(currentUser, name, holiday);
        return ResponseEntity.ok("매장 휴무일이 수정되었습니다.");
    }




}



