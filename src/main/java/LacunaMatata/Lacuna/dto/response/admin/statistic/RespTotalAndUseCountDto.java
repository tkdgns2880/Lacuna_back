package LacunaMatata.Lacuna.dto.response.admin.statistic;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespTotalAndUseCountDto {
    private int totalCount;
    List<RespServiceCountDto> serviceCount;
}
