package LacunaMatata.Lacuna.dto.response.admin.order;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class RespGetOrderItemDetailDto {
    private int orderItemId;
    private int orderId;
    private int orderProductId;
    private int quantity;
    private BigDecimal priceAtPurchase;
}
