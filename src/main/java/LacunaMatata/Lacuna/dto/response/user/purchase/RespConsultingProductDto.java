package LacunaMatata.Lacuna.dto.response.user.purchase;

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
    private String productCode;
    private String productName;
    private BigDecimal price;
    private BigDecimal promotionPrice;
    private String description;
    private String etc;
    private String productImg;

    private List<RespConsultingDetailProductDto> consultingDetail;
}
