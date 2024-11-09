package LacunaMatata.Lacuna.dto.response.user.mbti;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespMbtiStatusAndResultDto {
    private int mbtiResultStatus;
    private RespMbtiSurveyResultDto mbtiResult;
}
