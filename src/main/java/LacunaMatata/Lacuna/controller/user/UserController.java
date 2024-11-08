package LacunaMatata.Lacuna.controller.user;

import LacunaMatata.Lacuna.dto.request.user.user.ReqChangePhoneNumberDto;
import LacunaMatata.Lacuna.dto.request.user.user.ReqModifyProfileImgDto;
import LacunaMatata.Lacuna.dto.request.user.user.ReqPasswordChangeDto;
import LacunaMatata.Lacuna.dto.request.user.user.ReqWithdrawUserDto;
import LacunaMatata.Lacuna.dto.response.user.user.RespMyMbtiResultDto;
import LacunaMatata.Lacuna.dto.response.user.user.RespMyProfileDto;
import LacunaMatata.Lacuna.repository.user.UserMapper;
import LacunaMatata.Lacuna.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@Api(tags = {"userController"})
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    // 상단 header 프로필 정보 출력
    @ApiOperation(value = "getMyProfileHeaderApi")
    @GetMapping("/profile/header")
    public ResponseEntity<?> getMyProfileHeader() {
        return ResponseEntity.ok().body(userService.getMyProfileHeader());
    }

    // 프로필 페이지 출력
    @ApiOperation(value = "getMyProfileApi")
    @GetMapping("/user/profile")
    public ResponseEntity<?> getMyProfile() {
        RespMyProfileDto myProfile = userService.getMyProfile();
        return ResponseEntity.ok().body(myProfile);
    }

    // 프로필 페이지 - 프로필 사진 바꾸기
    @ApiOperation(value = "changeMyProfileImgApi")
    @PostMapping("/user/change/profile/img")
    public ResponseEntity<?> changeMyProfileImg(@ModelAttribute ReqModifyProfileImgDto dto) throws IOException {
        userService.changeMyProfileImg(dto);
        return ResponseEntity.ok().body(true);
    }

    // 프로필 페이지 - 비밀번호 바꾸기
    @PutMapping("/user/change/password")
    @ApiOperation(value = "passwordChangeApi")
    public ResponseEntity<?> passwordChange(@RequestBody ReqPasswordChangeDto dto) throws Exception {
        userService.passwordChange(dto);
        return ResponseEntity.ok().body(true);
    }

    // 프로필 페이지 - 내 연락처 바꾸기
    @PutMapping("/user/change/phone")
    @ApiOperation(value = "changeMyPhoneNumberApi")
    public ResponseEntity<?> changeMyPhoneNumber(@RequestBody ReqChangePhoneNumberDto dto) {
        userService.changePhoneNumber(dto);
        return ResponseEntity.ok().body(true);
    }

    // 프로필 페이지 - 회원 탈퇴
    @DeleteMapping("/user/delete")
    @ApiOperation(value = "withdrawUserApi")
    public ResponseEntity<?> withdrawUser(@RequestBody ReqWithdrawUserDto dto) throws Exception {
        userService.withdrawUser(dto);
        return ResponseEntity.ok().body(true);
    }

    // 프로필 페이지 - 내 mbti 결과 보기
    @GetMapping("/user/mbti/result")
    @ApiOperation(value = "getMbtiResultApi")
    public ResponseEntity<?> getMbtiResult() {
        RespMyMbtiResultDto myMbtiResult = userService.getMbtiResult();
        return ResponseEntity.ok().body(myMbtiResult);
    }
}
