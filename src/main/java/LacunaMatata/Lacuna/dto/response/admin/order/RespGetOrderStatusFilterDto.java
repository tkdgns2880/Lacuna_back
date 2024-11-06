package LacunaMatata.Lacuna.dto.response.admin.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespGetOrderStatusFilterDto {
    private int orderId;
    private String statusName;
}
