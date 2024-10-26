package LacunaMatata.Lacuna.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/************************************************
 * version: 1.0.4                               *
 * author: 손경태                                *
 * description: AdminUserManageController()-세팅 *
 * createDate: 2024-10-16                       *
 * updateDate: 2024-10-16                       *
 ************************************************/
@RestController
@RequestMapping("/api/v1/admin/user")
public class UserManageController {

    // 사용자 목록 출력
    @GetMapping("/list")
    ResponseEntity<?> getUserList() {
        return ResponseEntity.ok().body(null);
    }

    // 사용자 등록
    @PostMapping("/register")
    ResponseEntity<?> registerUser() {
        return ResponseEntity.ok().body(null);
    }

    // 사용자 수정(권한, 활성화)
    @PutMapping("/modify/{userId}")
    ResponseEntity<?> modifyUser() {
        return ResponseEntity.ok().body(null);
    }

    // 사용자 삭제
    @PostMapping("/delete/{userId}")
    ResponseEntity<?> deleteUser() {
        return ResponseEntity.ok().body(null);
    }

    // 사용자 복수개 삭제
    @PostMapping("/delete")
    ResponseEntity<?> deleteUserList() {
        return ResponseEntity.ok().body(null);
    }
}
