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
public class MbtiCategory {
    private int mbtiCategoryId;
    private int mbtiCategoryRegisterId;
    private String mbtiCategoryName;
    private String mbtiCategoryTitle;
    private String mbtiCategoryDescription;
    private String mbtiCategoryImg;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    // 서브쿼리 계산용
    private int totalCount;

    private User user; // resultMap association 용도
    private List<Mbti> mbtiList;
    private Mbti mbti;
}
