package LacunaMatata.Lacuna.repository.user;

import LacunaMatata.Lacuna.entity.mbti.MbtiResult;
import LacunaMatata.Lacuna.entity.user.*;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    /** auth 관련 mapper*/
    // 1-1.회원가입
    int saveUser(User user);
    // 1-2. 회원가입
    int saveUserOptionalInfo(UserOptionalInfo userOptionalInfo);
    // 1-3. 회원가입 - 권한 기본값 저장(member)_2024.11.01
    int saveUserRoleMet(Map<String, Object> params);
    // 1-4. 회원가입 - oauth 저장_2024.11.01
    int saveOauthInfo(SocialLogin socialLogin);
    // 2-1. 로그인
    int saveLoginHistory(LoginHistory loginHistory);
    // 2-2. 로그인
    int modifyLoginDate(int userId);
    // 3. 프로필 페이지 - 프로필 이미지 변경
    int modifyMyProfileImg(Map<String, Object> params);
    // 4-1. 마이페이지 - 비밀번호 변경하기(User)_2024.11.05
    int modifyPassword(int userId, String modifyPassword);
    // 4-2. 마이페이지 - 비밀번호 변경하기(PasswordHistory)_2024.11.05
    int savePasswordHistory(PasswordHistory passwordHistory);
    // 5. 마이페이지 - 폰 번호 변경하기
    int modifyPhoneNumber(Map<String, Object> params);
    // 6-1. 마이페이지 - 회원 탈퇴(User)_2024.11.05
    int deleteUser(int userId);
    // 6-2. 마이페이지 - 회원 탈퇴(UserOptionalInfo)_2024.11.05
    int deleteUserOptionalInfo(int userId);
    // 6-3. 마이페이지 - 회원 탈퇴(UserRoleMet)_2024.11.05
    int deleteUserRoleMet(int userId);
    // 6-4. 마이페이지 - 회원 탈퇴(SocialLogin)_2024.11.05
    int deleteOauthInfo(int userId);
    // 7. 마이페이지 - MBTI 결과_2024.11.05
    MbtiResult getMyMbtiResult(int usertId);

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
