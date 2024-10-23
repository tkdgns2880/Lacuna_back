package LacunaMatata.Lacuna.repository.user;

import LacunaMatata.Lacuna.entity.user.UserRoleMet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMetMapper {
    int saveUserRoleMat(UserRoleMet userRoleMet);
}
