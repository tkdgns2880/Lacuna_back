package LacunaMatata.Lacuna.service.user;

import LacunaMatata.Lacuna.dto.request.user.user.ReqChangePhoneNumberDto;
import LacunaMatata.Lacuna.dto.request.user.user.ReqModifyProfileImgDto;
import LacunaMatata.Lacuna.dto.request.user.user.ReqPasswordChangeDto;
import LacunaMatata.Lacuna.dto.request.user.user.ReqWithdrawUserDto;
import LacunaMatata.Lacuna.dto.response.user.user.RespMyMbtiResultDto;
import LacunaMatata.Lacuna.dto.response.user.user.RespMyProfileDto;
import LacunaMatata.Lacuna.dto.response.user.user.RespMyProfileHeaderDto;
import LacunaMatata.Lacuna.entity.mbti.MbtiResult;
import LacunaMatata.Lacuna.entity.user.PasswordHistory;
import LacunaMatata.Lacuna.entity.user.User;
import LacunaMatata.Lacuna.repository.user.UserMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Value("${file.path}")
    private String filePath;

    @Autowired
    private UserMapper userMapper;

    // 프로필 정보 (헤더부분) 출력
    public RespMyProfileHeaderDto getMyProfileHeader() {
        PrincipalUser principalUser
                = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();

        User user = userMapper.findUserByUserId(userId);
        RespMyProfileHeaderDto myProfileHeader = RespMyProfileHeaderDto.builder()
                .roleName(user.getRoleName())
                .profileImg(user.getUserOptionalInfo().getProfileImg())
                .build();
        return myProfileHeader;
    }

    // 프로필 페이지 출력 정보
    public RespMyProfileDto getMyProfile() {
        PrincipalUser principalUser
                = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();

        User user = userMapper.findUserByUserId(userId);
        RespMyProfileDto respMyProfileDto = RespMyProfileDto.builder()
                .name(user.getName())
                .phoneNumber(user.getUserOptionalInfo().getPhoneNumber())
                .email(user.getEmail())
                .profileImg(user.getUserOptionalInfo().getProfileImg())
                .build();
        return respMyProfileDto;
    }

    // 프로필 페이지 - 프로필 이미지 변경
    public void changeMyProfileImg(ReqModifyProfileImgDto dto) throws IOException {
        PrincipalUser principalUser
                = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();
        String profileImg = dto.getProfileImg();

        Map<String, Object> params = Map.of(
                "userId", userId,
                "profileImg", profileImg
        );
        userMapper.modifyMyProfileImg(params);
    }

    // 프로필 페이지 - 비밀번호 변경
    @Transactional(rollbackFor = Exception.class)
    public void passwordChange(ReqPasswordChangeDto dto) throws Exception {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();
        User user = userMapper.findUserByUserId(userId);

        if(!user.getPassword().equals(dto.getCurrentPassword())) {
            throw new Exception("현재 비밀번호 불일치");
        }

        String modifyPassword = dto.getModifyPassword();
        userMapper.modifyPassword(userId, modifyPassword);

        PasswordHistory passwordHistory = PasswordHistory.builder()
                .historyUserId(userId)
                .password(modifyPassword)
                .build();
        userMapper.savePasswordHistory(passwordHistory);
    }

    // 프로필 페이지 - 내 연락처 바꾸기
    public void changePhoneNumber(ReqChangePhoneNumberDto dto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();
        Map<String, Object> params = Map.of(
                "userId", userId,
                "phoneNumber", dto.getPhoneNumber()
        );

        userMapper.modifyPhoneNumber(params);
    }

    // 프로필페이지 - 회원 탈퇴
    @Transactional(rollbackFor = Exception.class)
    public void withdrawUser(ReqWithdrawUserDto dto) throws Exception {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();
        User user = userMapper.findUserByUserId(userId);

        String password = dto.getPassword();
        if(!user.getPassword().equals(password)) {
            throw new Exception("현재 비밀번호 불일치");
        }

        userMapper.deleteUser(userId);
        userMapper.deleteUserOptionalInfo(userId);
        userMapper.deleteUserRoleMet(userId);
        userMapper.deleteOauthInfo(userId);
        // 나머지 정보는 그대로 보존
    }

    // 마이페이지 - mbti 결과
    public RespMyMbtiResultDto getMbtiResult() {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();

        MbtiResult mbtiResult = userMapper.getMyMbtiResult(userId);
        RespMyMbtiResultDto myMbtiResultDto = RespMyMbtiResultDto.builder()
                .mbtiResultId(mbtiResult.getMbtiResultId())
                .mbtiResultCategoryName(mbtiResult.getMbtiResultCategoryName())
                .mbtiResultTitle(mbtiResult.getMbtiResultTitle())
                .mbtiResultSummary(mbtiResult.getMbtiResultSummary())
                .mbtiResultContent(mbtiResult.getMbtiResultContent())
                .mbtiResultImg(mbtiResult.getMbtiResultImg())
                .build();
        return myMbtiResultDto;
    }
}
