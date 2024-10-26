package LacunaMatata.Lacuna.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CosmeticDetail {
    private int cosmeticDetailId;
    private int cosmeticDetailProductId; // productId
    private String volume; //용량
    private String ingredient; // 성분
    private String skinType; // 피부타입
    private String effect; // 효능, 효과
    private String manufacture; // 제조사
    private String productDescription;
    private String productUrl; // 상품 url
    private String etc;
}
