package LacunaMatata.Lacuna.service.user;

import LacunaMatata.Lacuna.entity.user.UserCount;
import LacunaMatata.Lacuna.repository.user.StatisticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Service
public class StatisticService {

    @Autowired
    private StatisticMapper statisticMapper;

    // 서비스 이용통계 생성 서비스
    public void plusServiceCount(String serviceName) {
        Date now = new Date();

        LocalDate userDate = LocalDate.now();
        int userHour = now.getHours();

        Map<String, Object> params = Map.of(
            "serviceName", serviceName,
            "userDate", userDate,
            "userHour", userHour
        );

        // 날짜와 시간대에 해당하는 서비스 컬럼이 있는지 확인
        UserCount userCount = statisticMapper.findServiceByParams(params);

        if(userCount == null) {
            statisticMapper.saveUserCount(params); // 없으면 행 추가
            return;
        }
        statisticMapper.modifyUserCount(params); // 있으면 이용건수 + 1
    }
}
