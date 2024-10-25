package LacunaMatata.Lacuna.entity.cosmetic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CosmeticMetResult {
    private int cosmeticMetResultId;
    private int cosmeticMetResultMemberUserId; // ConsultingMember 테이블 consultingMemberId 외래키
    private int cosmeticMetResultConsultingUpperCategoryId; // consultingUpperCategoryId
    private int cosmeticMetResultConsultingLowerCategoryId; // consultingLowerCategoryId
    private int cosmeticMetResultProductLowerCategoryId; // productLowerCategoryId
    private int cosmeticMetResultProductId; // productId
    private int score;
    private String reason;
    private int cosmeticMetResultRegisterId; // userId 등록자 userId
    private int status; // 1- 임시저장, 2- 최종저장
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
