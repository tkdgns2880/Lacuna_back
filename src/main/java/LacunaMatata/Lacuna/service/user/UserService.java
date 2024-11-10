package LacunaMatata.Lacuna.service.user;

import LacunaMatata.Lacuna.dto.request.user.auth.ReqAuthEmailDto;
import LacunaMatata.Lacuna.dto.request.user.user.*;
import LacunaMatata.Lacuna.dto.response.user.user.RespMyMbtiResultDto;
import LacunaMatata.Lacuna.dto.response.user.user.RespMyProfileDto;
import LacunaMatata.Lacuna.dto.response.user.user.RespMyProfileHeaderDto;
import LacunaMatata.Lacuna.entity.mbti.MbtiResult;
import LacunaMatata.Lacuna.entity.user.PasswordHistory;
import LacunaMatata.Lacuna.entity.user.User;
import LacunaMatata.Lacuna.repository.user.UserMapper;
import LacunaMatata.Lacuna.security.jwt.JwtProvider;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import LacunaMatata.Lacuna.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
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

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthService authService;

    // 프로필 정보 (헤더부분) 출력
    public RespMyProfileHeaderDto getMyProfileHeader() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // authentication이 null이거나, principal이 PrincipalUser 인스턴스가 아닐 경우 비회원으로 간주하고 null 반환
        if (authentication == null || !(authentication.getPrincipal() instanceof PrincipalUser)) {
            return null;
        }
        PrincipalUser principalUser
                = (PrincipalUser) authentication.getPrincipal();
        int userId = principalUser.getId();

        User user = userMapper.findUserByUserId(userId);
        RespMyProfileHeaderDto myProfileHeader = RespMyProfileHeaderDto.builder()
                .name(user.getName())
                .username(user.getUsername())
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
        String kakaoUrl = userMapper.getKakaoAddress();

        RespMyProfileDto respMyProfileDto = RespMyProfileDto.builder()
                .name(user.getName())
                .phoneNumber(user.getUserOptionalInfo().getPhoneNumber())
                .email(user.getEmail())
                .profileImg(user.getUserOptionalInfo().getProfileImg())
                .marketingReceiveAgreement(user.getUserOptionalInfo().getMarketingReceiveAgreement())
                .kakaoAddress(kakaoUrl)
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

    // 프로필 페이지 - 내 이메일 주소 변경하기 (메일 인증)
    public Boolean changeMyEmail(ReqChangeMyEmailDto dto) {
        String toEmail = dto.getEmail();

        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<div style='display:flex;justify-content:center;align-items:center;flex-direction:column;"
                + "width:400px'>");
        htmlContent.append("<h2>Lacuna 메일 주소 변경 이메일 인증 입니다.</h2>");
        htmlContent.append("<h3>아래 인증하기 버튼을 클릭해주세요</h3>");
        htmlContent.append("<a target='_blank' href='http://localhost:8080/api/v1/auth/email?emailtoken=");
        htmlContent.append(jwtProvider.generateEmailValidToken(toEmail));
        htmlContent.append("'>인증하기</a>");
        htmlContent.append("</div>");

        return authService.send(toEmail, "Lacuna 메일 주소 변경 이메일 인증 ", htmlContent.toString());
    }

    // 프로필 페이지 - 내 이메일 주소 변경하기 (수정)
    public void changeMyEmail2(ReqChangeMyEmailDto dto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();
        String email = dto.getEmail();
        Map<String, Object> params = Map.of(
                "userId", userId,
                "email", email
        );
        userMapper.modifyMyEmail(params);
    }

    // 프로필 페이지 - 마케팅 동의 설정 바꾸기
    public void changeMarketingAgreement(ReqChangeMarketingDto dto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();
        int marketingReceiveAgreement = dto.getMarketingReceiveAgreement();
        Map<String, Object> params = Map.of(
                "userId", userId,
                "marketingReceiveAgreement", marketingReceiveAgreement
        );
        userMapper.changeMarketingAgreement(params);
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
