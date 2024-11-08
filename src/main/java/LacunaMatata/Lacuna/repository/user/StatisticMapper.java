package LacunaMatata.Lacuna.repository.user;

import LacunaMatata.Lacuna.entity.user.UserCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface StatisticMapper {

    /** 이용통계 서비스 관련 Mapper */
    // 1. 이용 통계 서비스 추가
    int saveUserCount(Map<String, Object> params);
    // 2. 이용 통계 서비스 수정
    int modifyUserCount(Map<String, Object> params);

    /** 공통으로 사용할 Mapper*/
    // 1. 날짜 시간, 서비스 이름으로 데이터 찾기
    UserCount findServiceByParams(Map<String, Object> params);
}
