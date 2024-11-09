package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;

import java.util.List;

@Data
public class ReqDeleteMbtiQuestionDto {
    private List<Integer> mbtiSurveyIdList;
}
