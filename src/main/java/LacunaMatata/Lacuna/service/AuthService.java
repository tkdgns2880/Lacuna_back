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
import java.time.LocalDateTime;
import java.util.List;

/************************************
 * version: 1.0.5                   *
 * author: 손경태                    *
 * description: AuthService         *
 * createDate: 2024-10-17           *
 * updateDate: 2024-10-21           *
 ***********************************/
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
                .marketingReceiveAgreement(dto.getMarketingReceiveAgreement())
                .thirdPartyInfoSharingAgreement(dto.getThirdPartyInfoSharingAgreement())
                .useConditionAgreement(dto.getUseConditionAgreement())
                .build();

        userMapper.saveUserOptionalInfo(userOptionalInfo);
    }

    // 일반 로그인
    public String signin(HttpServletRequest request, ReqGeneralSigninDto dto) {
        User user = userMapper.findUserByUsername(dto.getUsername());

        // 입력한 로그인 아이디가 있는지 확인 -> 없으면 오류
        if(user == null) {
            throw new RuntimeException("없는 아이디"); // 나중에 사용자 정보를 확인하세요로 고칠 부분
        }

        // 입력한 아이디가 존재할 때 해당 아이디의 비밀번호가 일치하는지 확인 => 없으면 오류
        if(!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("사용자 정보를 확인하세요");
        }

        // 아이디와 비밀번호가 일치했을 때 해당 계정이 휴면 상태인지 확인하기 위해 휴면 정보 불러오기
        InactiveAccount inactiveAccount = userMapper.findInactiveAccountByUserId(user.getUserId());

        // 만약 아직 정보가 저장되어있지 않다면(회원가입 직후 일 때) 새로 생성해서 넣어주기
        if(inactiveAccount == null) {
            InactiveAccount newInactiveAccount = InactiveAccount.builder()
                    .activityUserId(user.getUserId())
                    .build();
            userMapper.saveInactiveAccount(newInactiveAccount);
        }

        // 휴면 정보를 가지고 왔는데 활성화 시점이 로그인한 시점으로부터 1년이 지난 경우 비활성화로 바꿈
        if(inactiveAccount.getLastActiveDate().isBefore(LocalDateTime.now().minusYears(1))) {
            userMapper.changeInactiveFlagDisable(user.getUserId());
        }

        // 비활성화인 경우 오류 뜨게 만들기
        if(inactiveAccount.getInactiveFlag() == 2) {
            // 비활성화 풀 수 있게끔 이메일 날리는 요청
            throw new RuntimeException("비활성 계정");
        }

        // 로그인 시점이 1년이 지나지 않아 아직 활성화 상태인경우 활성화시점을 오늘로 업데이트 해주기
        userMapper.modifyInactiveAccount(user.getUserId());

        // ip와 토큰 가져오기
        String loginIp = IpUtils.getClientIp(request);
        String accessToken = jwtProvider.generateAccessToken(user.getUserId());

        // 로그인 정보에 로그인 시간과 ip 저장하기
        LoginHistory loginHistory = LoginHistory.builder()
                .loginUserId(user.getUserId())
                .loginIp(loginIp)
                .build();
        userMapper.saveLoginHistory(loginHistory);

        return accessToken;
    }

    // 휴면 계정을 이메일 인증으로 풀었을 때 다시 활성화 상태로 업데이트 하는 기능
    // 아직 이메일 인증 요청 컨트롤러 안 만듦(나중에 만들고 테스트 해보기)
    public void changeInactiveFlagAble(int userId) {
        userMapper.changeInactiveFlagAble(userId);
    }
}
