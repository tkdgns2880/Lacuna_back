package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqGetUseCountDto;
import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqGetStatisticCountsDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespMbtiStatisticCountDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespMbtiStatisticRankDto;
import LacunaMatata.Lacuna.entity.user.UserCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatisticsMapper {
    // 1. 날짜에 따른 이용통계 정보
    List<UserCount> getUseCountByDate(Map<String, Object> params);
    // 2-1. 날짜에 따른 MBTI 정보 관련 ???
    List<RespMbtiStatisticCountDto> getStatisticCountByStartDateAndEndDate(ReqGetStatisticCountsDto dto);
    // 2-2. 날짜에 따른 MBTI 정보 관련 ???
//    RespMbtiStatisticCountDto mbtiStatistic(ReqGetStatisticCountsDto dto);    필요없음.
    // 2-3. 날짜에 따른 MBTI 정보 관련 ???
    List<RespMbtiStatisticRankDto> problemStatistic(ReqGetStatisticCountsDto dto);
}
