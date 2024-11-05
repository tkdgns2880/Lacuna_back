package LacunaMatata.Lacuna.dto.response.admin.product;

import LacunaMatata.Lacuna.entity.product.ConsultingDetail;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class RespConsultingDetailDto{
    private int productId;
    private int productUpperCategoryId;
    private int productLowerCategoryId;
    private String productUpperCategoryName;
    private String productLowerCategoryName;
    private String productCode;
    private String productName;
    private BigDecimal price;
    private BigDecimal promotionPrice;
    private String productImg;
    private String description;
    private String etc; // 기타사항

    private List<ConsultingDetail> consultingDetail;
}
