package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqMbtiStatisticDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespMbtiStatisticCountDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespUserProblemStatisticCount;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespUserStatisticCountDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {
    RespUserStatisticCountDto userStatistic(ReqMbtiStatisticDto dto);
    RespMbtiStatisticCountDto mbtiStatistic(ReqMbtiStatisticDto dto);
    List<RespUserProblemStatisticCount> problemStatistic(ReqMbtiStatisticDto dto);
}
