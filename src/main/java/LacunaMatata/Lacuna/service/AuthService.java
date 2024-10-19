package LacunaMatata.Lacuna.service;

import LacunaMatata.Lacuna.dto.request.user.auth.ReqGeneralSigninDto;
import LacunaMatata.Lacuna.dto.request.user.auth.ReqGeneralSignupDto;
import LacunaMatata.Lacuna.entity.user.InactiveAccount;
import LacunaMatata.Lacuna.entity.user.LoginHistory;
import LacunaMatata.Lacuna.entity.user.User;
import LacunaMatata.Lacuna.entity.user.UserOptionalInfo;
import LacunaMatata.Lacuna.repository.user.UserMapper;
import LacunaMatata.Lacuna.security.ip.IpUtils;
import LacunaMatata.Lacuna.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private IpUtils ipUtils;

    // 일반 회원 가입
    public void signup(ReqGeneralSignupDto dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .name(dto.getName())
                .build();
        userMapper.saveUser(user);
        int userId = user.getUserId();
        UserOptionalInfo userOptionalInfo = UserOptionalInfo.builder()
                .userId(user.getUserId())
                .birthDate(dto.getBirthDate())
                .gender(dto.getGender())
                .phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress())
                .marketingOptIn(dto.getMarketingOptIn())
                .thirdPartyInfoSharingConsent(dto.getThirdPartyInfoSharingConsent())
                .build();

        userMapper.saveUserOptionalInfo(userOptionalInfo);
    }

    // 일반 로그인
    public String signin(HttpServletRequest request, ReqGeneralSigninDto dto) {
        User user = userMapper.findUserByUsername(dto.getUsername());
        System.out.println(dto.getUsername());
        System.out.println(user);

        if(user == null) {
            throw new RuntimeException("없는 아이디"); // 나중에 사용자 정보를 확인하세요로 고칠 부분
        }

        if(!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("사용자 정보를 확인하세요");
        }
        String loginIp = IpUtils.getClientIp(request);
        String accessToken = jwtProvider.generateAccessToken(user.getUserId());

        System.out.println(user.getUserId());

        LoginHistory loginHistory = LoginHistory.builder()
                .loginUserId(user.getUserId())
                .loginIp(loginIp)
                .build();
        System.out.println(loginHistory);
        userMapper.saveLoginHistory(loginHistory);

        InactiveAccount inactiveAccount = userMapper.findInactiveAccountByUserId(user.getUserId());

        if(inactiveAccount == null) {
            InactiveAccount newInactiveAccount = InactiveAccount.builder().build();
            userMapper.saveInactiveAccount(newInactiveAccount);
        }
        userMapper.modifyInactiveAccount(user.getUserId());

        return accessToken;
    }
}
