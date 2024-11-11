package LacunaMatata.Lacuna.dto.response.admin.statistic;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RespMbtiStatisticCountAndRankDto {
    private List<RespMbtiStatisticCountDto> mbtiStatisticCounts;
    private List<RespMbtiStatisticRankDto> mbtiStatisticRanks;
}
