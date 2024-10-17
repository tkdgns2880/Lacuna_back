package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class RespProductDto {
    private String productCode;
    private String productUpperCategoryName;
    private String productName;
    private int price;
    private int promotionPrice;
    private String name;
    private LocalDateTime createdDate;
}
