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
    private int solutionResultConsultingLowerCategoryId; // consultingLowerCategoryId
    private String timeZone;
    private int solutionResultProductLowerCategoryId; // productLowerCategoryId
    private int solutionResultProductId; //productId
    private int order; // 사용순서
    private String scope; // 사용 범위
    private String amount; // 사용량
    private int count; // 사용 횟수
    private int solutionResultRegisterId; // userId 등록자
    private int status; // 저장상태
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
