package LacunaMatata.Lacuna.dto.response.admin.order;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class RespGetOrderDto {
    private int orderId;
    private String name;
    private String roleName;
    private int totalAmount;
    private LocalDateTime createdDate;
    private String status;
}
