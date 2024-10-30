package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class RespConsultingDetailDto{
    private int productId;
    private int productUpperCategoryId;
    private String productUpperCategoryName;
    private String productLowerCategoryName;
    private String productCode;
    private String productName;
    private BigDecimal price;
    private BigDecimal promotionPrice;
    private String productImg;

    private int repeatCount; // 컨설팅 반복 횟수
    private String consultingDescription; // 컨설팅 상품 설명
    private String consultingName; // 컨설팅 상품 이름

    private String etc; // 기타사항
}
