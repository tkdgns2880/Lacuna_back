package LacunaMatata.Lacuna.dto.response.user.user;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
public class RespMyOrderInfoDto {
    private int orderId;
    private String productUpperCategoryName;
    private LocalDateTime create_date;
    private String productName;
    private String status;
    private int quantity;
    private BigDecimal priceAtPurchase;
}
