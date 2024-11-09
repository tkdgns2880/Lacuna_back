package LacunaMatata.Lacuna.dto.request.user.mbti;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ReqMbtiAnswerDto {
    private int gender;
    private Date birth;
    private int skinProblemOne;
    private int skinProblemTwo;
    private List<ReqMbtiSurveyDto> mbtiResult;
}
