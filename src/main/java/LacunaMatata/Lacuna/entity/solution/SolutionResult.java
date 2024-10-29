package LacunaMatata.Lacuna.entity.solution;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SolutionResult {
    private int solutionResultId;
    private int solutionResultMemberUserId; // consultingMemberId
    private int solutionResultConsultingUpperCategoryId; // consultingUpperCategoryId
    private String skinPurpose;
    private String eatingHabit;
    private String lifestyleHabit;
    private String cosmeticProduct;
    private int solutionResultRegisterId; // userId 등록자
    private int status; // 저장상태
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
