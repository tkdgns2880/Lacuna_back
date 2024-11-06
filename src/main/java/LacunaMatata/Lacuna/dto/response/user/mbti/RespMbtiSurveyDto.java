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
public class RespMbtiSurveyDto {
    private int mbtiCategoryId;
    private String mbtiCategoryName;
    private String mbtiCategoryTitle;
    private String mbtiCategoryDescription;
    private String mbtiCategoryImg;

    private List<RespMbtiQuestionDto> mbti;
}
