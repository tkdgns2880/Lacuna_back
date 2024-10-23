package LacunaMatata.Lacuna.repository.user;

import LacunaMatata.Lacuna.entity.user.InactiveAccount;
import LacunaMatata.Lacuna.entity.user.LoginHistory;
import LacunaMatata.Lacuna.entity.user.User;
import LacunaMatata.Lacuna.entity.user.UserOptionalInfo;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper {
    User findUserByUserId(int userId);
    User findUserByUsername(String username);
    int saveUser(User user);
    int saveUserOptionalInfo(UserOptionalInfo userOptionalInfo);
    int saveLoginHistory(LoginHistory loginHistory);
    List<LoginHistory> findLoginHistoryByUserId(int userId);
    int modifyLoginDate(int userId);
}
