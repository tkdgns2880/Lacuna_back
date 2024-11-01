package LacunaMatata.Lacuna.entity.mbti;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MbtiResultImg {
    private Long mbtiResultImgId;
    private int mbtiResultImgMbtiResultId;
    private String imgPath;
}
