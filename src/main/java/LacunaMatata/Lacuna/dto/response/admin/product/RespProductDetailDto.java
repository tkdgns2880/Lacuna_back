package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class RespProductDetailDto {
    private int productId;
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

    private String volume; // 화장품 상품 용량
    private String ingredient; // 화장품 상품 성분
    private String skinType; // 화장품 상품 피부타입
    private String effect; // 화장품 상품 효능
    private String manufacture; // 화장품 상품 제조사
    private String cosmeticProductDescription; // 화장품 상품 설명
    private String productUrl; // 화장품 상품 url

    private String etc; // 기타사항
}
