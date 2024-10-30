package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.dto.request.admin.usermanage.ReqDeleteUserListDto;
import LacunaMatata.Lacuna.dto.request.admin.usermanage.ReqGetUserListDto;
import LacunaMatata.Lacuna.dto.response.admin.usermanage.RespCountAndUserListDto;
import LacunaMatata.Lacuna.service.admin.UserManageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserManageService userManageService;

    // 사용자 목록 출력
    @GetMapping("/list")
    ResponseEntity<?> getUserList(ReqGetUserListDto dto) {
        RespCountAndUserListDto respCountAndUserListDto = userManageService.getUserInfoList(dto);
        return ResponseEntity.ok().body(respCountAndUserListDto);
    }

    // 사용자 등록
    @PostMapping("/regist")
    ResponseEntity<?> registerUser() {
        return ResponseEntity.ok().body(true);
    }

    // 사용자 항목 출력
    @GetMapping("/{userId}")
    ResponseEntity<?> getUser(@PathVariable String userId) {

        return ResponseEntity.ok().body(true);
    }

    // 사용자 권한 목록 출력
    @GetMapping("/role/list")
    ResponseEntity<?> getUserRoleList() {

        return ResponseEntity.ok().body(true);
    }

    // 사용자 수정(권한, 활성화)
    @PutMapping("/modify/{userId}")
    ResponseEntity<?> modifyUser() {
        return ResponseEntity.ok().body(true);
    }

    // 사용자 삭제
    @PostMapping("/delete/{userId}")
    @ApiOperation(value = "deleteUserApi")
    ResponseEntity<?> deleteUser(@PathVariable int userId) {
        userManageService.deleteUser(userId);
        return ResponseEntity.ok().body(true);
    }

    // 사용자 복수개 삭제
    @PostMapping("/delete")
    @ApiOperation(value = "deleteUserListApi")
    ResponseEntity<?> deleteUserList(@RequestBody ReqDeleteUserListDto dto) {
        userManageService.deleteUserList(dto);
        return ResponseEntity.ok().body(true);
    }
}
