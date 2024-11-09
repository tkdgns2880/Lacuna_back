package LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductList;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class RespConsultingListDto {
    private int productId;
    private String productName;
    private String subtitle;
    private BigDecimal price;
    private BigDecimal promotionPrice;
    private String description;
}
