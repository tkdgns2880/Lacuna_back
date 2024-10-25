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
public class ConsultingMemberDetailInfo {
    private int consultingMemberDetailId;
    private int consultingMemberDetailUserId; // ConsultingMemberInfo 테이블 consulting_memberId 외래키
    private LocalDateTime personalConsultingDate;
    private int personalConsultingStatus;
    private String specialInfo;
}
