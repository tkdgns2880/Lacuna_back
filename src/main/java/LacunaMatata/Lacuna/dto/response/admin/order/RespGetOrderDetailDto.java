package LacunaMatata.Lacuna.dto.response.admin.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespGetOrderDetailDto {
    private int orderId;
    private int paymentId;
    private String name;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private String status;
    private LocalDateTime createdDate;
    private List<RespGetOrderItemDetailDto> orderDetailItem;
}
