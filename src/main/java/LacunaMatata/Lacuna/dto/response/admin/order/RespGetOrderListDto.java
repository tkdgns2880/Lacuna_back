package LacunaMatata.Lacuna.dto.response.admin.order;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
public class RespGetOrderListDto {
    private int orderId;
    private String name;
    private String roleName;
    private BigDecimal totalAmount;
    private LocalDateTime createdDate;
    private String status;
}
