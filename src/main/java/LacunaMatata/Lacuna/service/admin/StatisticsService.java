package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqMbtiStatisticDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespAllCountDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespMbtiStatisticCountDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespUserProblemStatisticCount;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespUserStatisticCountDto;
import LacunaMatata.Lacuna.repository.admin.StatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;

    public RespAllCountDto respAllCountDto(ReqMbtiStatisticDto dto) {
        RespUserStatisticCountDto respUserStatisticCountDto = null;
        RespMbtiStatisticCountDto respMbtiStatisticCountDto = null;
        List<RespUserProblemStatisticCount> respUserProblemStatisticCounts = null;

        if (dto.getStartDate() != null && dto.getEndDate() != null) {
            respUserStatisticCountDto = statisticsMapper.userStatistic(dto);
            respMbtiStatisticCountDto = statisticsMapper.mbtiStatistic(dto);
            respUserProblemStatisticCounts = statisticsMapper.problemStatistic(dto);
        }

        return RespAllCountDto.builder()
                .respUserStatisticCountDto(respUserStatisticCountDto)
                .respMbtiStatisticCountDto(respMbtiStatisticCountDto)
                .respUserProblemStatisticCount(respUserProblemStatisticCounts)
                .build();
    }
}
