package LacunaMatata.Lacuna.dto.request.user.mbti;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ReqMbtiAnswerDto {
    private int gender;
    private Date birthDate;
    private List<Integer> mbtiSkinConcernIdList;
    private List<ReqMbtiSurveyDto> mbtiResult;
}
