package LacunaMatata.Lacuna.dto.response.admin.order;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Builder
@Data
public class RespGetOrderDetailDto {
    private int orderId;
    private String name;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private String status;
    private LocalDateTime createdDate;
    private List<RespGetOrderItemDetailDto> orderDetailItem;
}
