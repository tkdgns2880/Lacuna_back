package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.dto.request.admin.usermanage.ReqDeleteUserListDto;
import LacunaMatata.Lacuna.dto.request.admin.usermanage.ReqGetUserListDto;
import LacunaMatata.Lacuna.dto.request.admin.usermanage.ReqModifyUserDto;
import LacunaMatata.Lacuna.dto.request.admin.usermanage.ReqRegistUserDto;
import LacunaMatata.Lacuna.dto.response.admin.usermanage.RespCountAndUserListDto;
import LacunaMatata.Lacuna.dto.response.admin.usermanage.RespGetModifyUserModalDto;
import LacunaMatata.Lacuna.dto.response.admin.usermanage.RespUserDetailDto;
import LacunaMatata.Lacuna.dto.response.admin.usermanage.RespUserRoleFilterDto;
import LacunaMatata.Lacuna.service.admin.UserManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/************************************************
 * version: 1.0.4                               *
 * author: 손경태                                *
 * description: AdminUserManageController()-세팅 *
 * createDate: 2024-10-16                       *
 * updateDate: 2024-10-16                       *
 ************************************************/
@RestController
@RequestMapping("/api/v1/admin/user")
@Api(tags = {"UserManageController"})
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    // 사용자 목록 출력
    @GetMapping("/list")
    @ApiOperation(value = "getUserListApi") // test 완료
    public ResponseEntity<?> getUserList(ReqGetUserListDto dto) {
        RespCountAndUserListDto respCountAndUserListDto = userManageService.getUserInfoList(dto);
        return ResponseEntity.ok().body(respCountAndUserListDto);
    }

    // 사용자 등록
    @PostMapping("/regist")
    @ApiOperation(value = "registerUserApi") // test 완료
    public ResponseEntity<?> registerUser(@RequestBody ReqRegistUserDto dto) {
        userManageService.registUser(dto);
        return ResponseEntity.ok().body(true);
    }

    // 사용자 권한 목록 출력(필터)
    @GetMapping("/role/list/filter")
    @ApiOperation(value = "getUserRoleListApi") // test 완료
    public ResponseEntity<?> getUserRoleList() {
        List<RespUserRoleFilterDto> userRoleList = userManageService.getUserRoleList();
        return ResponseEntity.ok().body(userRoleList);
    }

    // 사용자 수정창 모달 출력
    @GetMapping("/modify/{userId}")
    @ApiOperation(value = "getModifyModalApi")
    public ResponseEntity<?> getModifyModal(@PathVariable int userId) {
        RespGetModifyUserModalDto modifyUserModal = userManageService.getUserModifyModal(userId);
        return ResponseEntity.ok().body(modifyUserModal);
    }

    // 사용자 수정(권한, 활성화)
    @PutMapping("/modify/{userId}")
    @ApiOperation(value = "modifyUserApi") // test 완료
    public ResponseEntity<?> modifyUser(@RequestBody ReqModifyUserDto dto, @PathVariable int userId) {
        userManageService.modifyUser(dto);
        return ResponseEntity.ok().body(true);
    }

    // 사용자 삭제
    @DeleteMapping("/delete/{userId}")
    @ApiOperation(value = "deleteUserApi") // test 완료
    public ResponseEntity<?> deleteUser(@PathVariable int userId) {
        userManageService.deleteUser(userId);
        return ResponseEntity.ok().body(true);
    }

    // 사용자 복수개 삭제
    @DeleteMapping("/delete")
    @ApiOperation(value = "deleteUserListApi") // test 완료
    public ResponseEntity<?> deleteUserList(@RequestBody ReqDeleteUserListDto dto) {
        userManageService.deleteUserList(dto);
        return ResponseEntity.ok().body(true);
    }
}
