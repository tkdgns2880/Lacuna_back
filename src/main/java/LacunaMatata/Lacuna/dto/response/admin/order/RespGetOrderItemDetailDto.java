package LacunaMatata.Lacuna.dto.response.admin.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespGetOrderItemDetailDto {
    private int orderItemId;
    private int orderId;
    private String productName;
    private int quantity;
    private BigDecimal priceAtPurchase;
}
