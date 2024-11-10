package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqGetUseCountDto;
import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqMbtiStatisticDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespMbtiStatisticCountDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespUserProblemStatisticCount;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespUserStatisticCountDto;
import LacunaMatata.Lacuna.entity.user.UserCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {

    // 1. 날짜에 따른 이용통계 정보
    List<UserCount> getUseCountByDate(ReqGetUseCountDto dto);

    // 1. 날짜에 따른 MBTI 정보 관련 Mapper
    RespUserStatisticCountDto userStatistic(ReqMbtiStatisticDto dto);
    RespMbtiStatisticCountDto mbtiStatistic(ReqMbtiStatisticDto dto);
    List<RespUserProblemStatisticCount> problemStatistic(ReqMbtiStatisticDto dto);
}
