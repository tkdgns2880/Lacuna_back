package LacunaMatata.Lacuna.repository.user;

import LacunaMatata.Lacuna.entity.user.*;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper {

    /** auth 관련 mapper*/
    // 1-1.회원가입
    int saveUser(User user);
    // 1-2. 회원가입
    int saveUserOptionalInfo(UserOptionalInfo userOptionalInfo);
    // 1-3. 회원가입 - 권한 기본값 저장(member)_2024.11.01
    int saveUserRoleMet(UserRoleMet userRoleMet);
    // 1-4. 회원가입 - oauth 저장_2024.11.01
    int saveOauthInfo(SocialLogin socialLogin);
    // 2-1. 로그인
    int saveLoginHistory(LoginHistory loginHistory);
    // 2-2. 로그인
    int modifyLoginDate(int userId);

    /** 공통으로 사용할 userMapper */
    // 1. userId로 User 정보 찾기
    User findUserByUserId(int userId);
    // 2. username으로 User 정보 찾기
    User findUserByUsername(String username);
    // 3. email로 User 정보 찾기
    User findUserByEmail(String email);
    // 4. roleId로 UserRole 정보 찾기
    UserRole findUserRoleByRoleId(int roleId);
    // 5. userId로 로그인 기록 정보 찾기
    List<LoginHistory> findLoginHistoryByUserId(int userId);
    // 6. oAuth2Name(고유값)으로 사용자 찾기
    User findUserBySocialId(String socialId);
}
