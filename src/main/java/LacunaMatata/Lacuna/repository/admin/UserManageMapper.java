package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserManageMapper {

    /** 사용자 관리용 mapper */
    // 1. 사용자 목록 리스트 출력_2024_10-30
    List<User> getUserList(Map<String, Object> params);

    // 사용자 삭제
    int deleteByUserId(int userId);
    // 사용자 복수개 삭제
    int deleteByuserList(List<Integer> userIdList);
}
