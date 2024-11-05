package LacunaMatata.Lacuna.service.user;

import LacunaMatata.Lacuna.dto.request.user.user.ReqPasswordChangeDto;
import LacunaMatata.Lacuna.dto.request.user.user.ReqWithdrawUserDto;
import LacunaMatata.Lacuna.dto.response.user.user.RespMyProfileDto;
import LacunaMatata.Lacuna.entity.user.PasswordHistory;
import LacunaMatata.Lacuna.entity.user.User;
import LacunaMatata.Lacuna.repository.user.UserMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionalOperator;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TransactionalOperator transactionalOperator;

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

}
