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

    // 1-1. 처음 초기 데이터 불러오기(이용통계)
    List<UserCount> getInitData();
    // 1-2. 처음 초기 데이터 불러오기(MBTI 정보1)
    RespUserStatisticCountDto getInitUseCount();
    // 1-3. 처음 초기 데이터 불러오기(MBTI 정보1)
    RespMbtiStatisticCountDto mbtiInitStatistic();
    // 1-4. 처음 초기 데이터 불러오기(MBTI 정보1)
    List<RespUserProblemStatisticCount> problemInitStatistic();
    // 2. 날짜에 따른 이용통계 정보
    List<UserCount> getUseCountByDate(ReqGetUseCountDto dto);
    // 3-1. 날짜에 따른 MBTI 정보 관련 ???
    RespUserStatisticCountDto userStatistic(ReqMbtiStatisticDto dto);
    // 3-2. 날짜에 따른 MBTI 정보 관련 ???
    RespMbtiStatisticCountDto mbtiStatistic(ReqMbtiStatisticDto dto);
    // 3-3. 날짜에 따른 MBTI 정보 관련 ???
    List<RespUserProblemStatisticCount> problemStatistic(ReqMbtiStatisticDto dto);
}
