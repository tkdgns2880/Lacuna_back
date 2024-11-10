package LacunaMatata.Lacuna.dto.response.admin.statistic;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RespAllCountDto {
    private RespUserStatisticCountDto respUserStatisticCountDto;
    private RespMbtiStatisticCountDto respMbtiStatisticCountDto;
    private List<RespUserProblemStatisticCount> respUserProblemStatisticCount;
}
