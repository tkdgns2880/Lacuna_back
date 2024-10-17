package LacunaMatata.Lacuna.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/************************************************
 * version: 1.0.4                               *
 * author: 손경태                                *
 * description: SettingController()-세팅         *
 * createDate: 2024-10-16                       *
 * updateDate: 2024-10-16                       *
 ************************************************/
@RestController
@RequestMapping("/auth/admin/settings")
public class SettingController {

    // 설정(약관 email, phone, sns 주소 등) 정보 불러오기
    @GetMapping("/")
    ResponseEntity<?> getSettingList() {
        return ResponseEntity.ok().body(null);
    }

    // 설정(약관 email, phone, sns 주소 등) 항목 수정
    @PutMapping("/modify/{settingId}")
    ResponseEntity<?> modifySetting() {
        return ResponseEntity.ok().body(null);
    }
}
