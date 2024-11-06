package LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductDetail;

import LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductList.RespConsultingDetailProductDto;
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
public class RespConsultingProductDetailDto {
    private int productId;
    private int productLowerCategoryId;
    private String productLowerCategoryName;

    private String productCode;
    private String productName;
    private BigDecimal price;
    private BigDecimal promotionPrice;
    private String description;
    private String etc;
    private String productImg;

    private List<RespConsultingDetailProductDto> consultingDetail;
}
