package LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespConsultingProductDto {
    private int productId;
    private String productName;
    private BigDecimal price;
    private BigDecimal promotionPrice;
    private String description;
    private String productImg;

    private List<RespConsultingDetailProductDto> consultingDetail;
}
