package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
public class RespProductDto {
    private int productId;
    private String productCode;
    private String productUpperCategoryName;
    private String productName;
    private BigDecimal price;
    private BigDecimal promotionPrice;
    private String name;
    private LocalDateTime createdDate;
}
