package LacunaMatata.Lacuna.dto.response.admin.statistic;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespInitAllDataDto {
    RespTotalAndUseCountDto initAllStatisticData;
    RespAllCountDto initAllCount;
}
