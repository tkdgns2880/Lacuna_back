package LacunaMatata.Lacuna.entity.consulting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultingMemberInfo {
    private int consultingMemberId;
    private int consultingMemberUserId; // user테이블 userId 외래키
    private int consultingMemberPurchaseInfoId; // purchaseInfo 테이블 purchaseId 외래키
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
