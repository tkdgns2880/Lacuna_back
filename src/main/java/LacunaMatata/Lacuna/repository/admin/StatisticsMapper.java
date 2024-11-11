package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqGetUseCountDto;
import LacunaMatata.Lacuna.dto.request.admin.statistic.ReqGetStatisticCountsDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespMbtiStatisticCountDto;
import LacunaMatata.Lacuna.dto.response.admin.statistic.RespMbtiStatisticRankDto;
import LacunaMatata.Lacuna.entity.user.UserCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {

    // 1-1. 처음 초기 데이터 불러오기(이용통계)
    List<UserCount> getInitData();
    // 1-2. 처음 초기 데이터 불러오기(MBTI 정보1)
//    RespStatisticCountDto getInitUseCount();      필요없음.
    // 1-3. 처음 초기 데이터 불러오기(MBTI 정보1)
//    RespMbtiStatisticCountDto mbtiInitStatistic();
    // 1-4. 처음 초기 데이터 불러오기(MBTI 정보1)
    List<RespMbtiStatisticRankDto> problemInitStatistic();
    // 2. 날짜에 따른 이용통계 정보
    List<UserCount> getUseCountByDate(ReqGetUseCountDto dto);
    // 3-1. 날짜에 따른 MBTI 정보 관련 ???
    List<RespMbtiStatisticCountDto> getStatisticCountByStartDateAndEndDate(ReqGetStatisticCountsDto dto);
    // 3-2. 날짜에 따른 MBTI 정보 관련 ???
//    RespMbtiStatisticCountDto mbtiStatistic(ReqGetStatisticCountsDto dto);    필요없음.
    // 3-3. 날짜에 따른 MBTI 정보 관련 ???
    List<RespMbtiStatisticRankDto> problemStatistic(ReqGetStatisticCountsDto dto);
}
