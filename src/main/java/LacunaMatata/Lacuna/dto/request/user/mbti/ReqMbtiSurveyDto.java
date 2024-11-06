package LacunaMatata.Lacuna.dto.request.user.mbti;

import lombok.Data;

import java.util.List;

@Data
public class ReqMbtiSurveyDto {
    private int mbtiCategoryId;
    private List<ReqMbtiQuestionDto> mbti;
}
