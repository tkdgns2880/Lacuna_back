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
    // 2-1. 로그인
    int saveLoginHistory(LoginHistory loginHistory);
    // 2-2. 로그인
    int modifyLoginDate(int userId);

    /** 공통으로 사용할 userMapper */
    User findUserByUserId(int userId);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    UserRole findUserRoleByRoleId(int roleId);
    List<LoginHistory> findLoginHistoryByUserId(int userId);
}
