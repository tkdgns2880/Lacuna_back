package LacunaMatata.Lacuna.dto.request.admin.product;

import lombok.Data;

@Data
public class ReqRegistProductDto {
    private String productUpperCategoryName;
    private String productLowerCategoryName;
    private String productCode;
    private String productName;
    private int price;
    private int promotionPrice;
    private String productImg;

    // 상위 분류가 컨설팅일때 받을 곳
    private int repeatCount; // 컨설팅 반복 횟수
    private String consultingDescription; // 컨설팅 상품 설명
    private String consultingName; // 컨설팅 상품 이름

    // 상위 분류가 화장품일 때 받을 곳
    private String volume; // 화장품 상품 용량
    private String ingredient; // 화장품 상품 성분
    private String skinType; // 화장품 상품 피부타입
    private String effect; // 화장품 상품 효능
    private String manufacture; // 화장품 상품 제조사
    private String cosmeticProductDescription; // 화장품 상품 설명
    private String productUrl; // 화장품 상품 url

    // 카테고리 공통 부분 받을 곳
    private String etc; // 기타사항
}
