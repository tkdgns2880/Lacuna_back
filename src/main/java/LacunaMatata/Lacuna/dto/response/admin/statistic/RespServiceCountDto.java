package LacunaMatata.Lacuna.dto.response.admin.statistic;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespServiceCountDto {
    private String serviceName;
    private int serviceCount;
}
