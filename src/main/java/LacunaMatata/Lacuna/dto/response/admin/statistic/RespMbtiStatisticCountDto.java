package LacunaMatata.Lacuna.dto.response.admin.statistic;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespMbtiStatisticCountDto {
    private String countType;
    private String countCode;
    private Integer count;
}