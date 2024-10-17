package LacunaMatata.Lacuna.dto.response.admin.order;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Builder
@Data
public class RespGetOrderDetailDto {
    private int orderId;
    private String name;
    private int totalAmount;
    private String status;
    private LocalDateTime createdDate;
    private List<Object> orderItemId;
}
