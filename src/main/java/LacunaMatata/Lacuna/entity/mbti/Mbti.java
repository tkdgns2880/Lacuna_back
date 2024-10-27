package LacunaMatata.Lacuna.entity.mbti;

import LacunaMatata.Lacuna.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mbti {
    private int mbtiId;
    private String mbtiCode;
    private int mbtiCategoryId;
    private int mbtiRegisterId;
    private String mbtiTitle;
    private String mbtiImg;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    // 매핑 목적
    private MbtiCategory mbtiCategory;
    private User user;
    private MbtiOption mbtiOption;
}
