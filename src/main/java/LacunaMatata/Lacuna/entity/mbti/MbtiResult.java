package LacunaMatata.Lacuna.entity.mbti;

import LacunaMatata.Lacuna.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MbtiResult {
    private int mbtiResultId;
    private int mbtiResultRegisterId;
    private String mbtiResultCategoryName;
    private String mbtiResultTitle;
    private String mbtiResultSummary;
    private String mbtiResultContent;
    private String mbtiResultImg;
    private int mbtiResultStatus;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    // 서브쿼리 계산용
    private int totalCount;

    // 조인용
    private String name;

    // 매핑용
    private User user;
}
