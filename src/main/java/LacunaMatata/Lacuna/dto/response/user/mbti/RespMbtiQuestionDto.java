package LacunaMatata.Lacuna.dto.response.user.mbti;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespMbtiQuestionDto {
    private int mbtiId;
    private String mbtiCode;
    private String mbtiTitle;
    private int mbtiCategoryId;
    private String mbtiImg;

    private List<RespMbtiOptionDto> mbtiOption;
}
