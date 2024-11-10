package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqGetUseCountDto;
import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqMbtiStatisticDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.*;
import LacunaMatata.Lacuna.entity.user.UserCount;
import LacunaMatata.Lacuna.repository.admin.StatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;

    // 날짜에 따라 이용통계 데이터 주기
    public RespTotalAndUseCountDto getUseCount(ReqGetUseCountDto dto) {
        List<UserCount> userCountList = statisticsMapper.getUseCountByDate(dto);

        List<RespServiceCountDto> respServiceCountDtoList = new ArrayList<>();
        int totalCount = 0;
        for(UserCount userCount : userCountList) {
            totalCount += userCount.getSumServiceCount();
            RespServiceCountDto resp = RespServiceCountDto.builder()
                    .serviceName(userCount.getServiceName())
                    .serviceCount(userCount.getSumServiceCount())
                    .build();
            respServiceCountDtoList.add(resp);
        }

        RespTotalAndUseCountDto useCount = RespTotalAndUseCountDto.builder()
                .totalCount(totalCount)
                .serviceCount(respServiceCountDtoList)
                .build();
        return useCount;
    }

    // mbti 통계 날짜에 따라 데이터 주기
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
