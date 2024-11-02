package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespProductDetailDto {
    private int productId;
    private int productUpperCategoryId;
    private String productUpperCategoryName;
    private String productLowerCategoryName;
    private String productCode;
    private String productName;
    private BigDecimal price;
    private BigDecimal promotionPrice;
    private String productImg;
    private String description;
    private String etc;
}
