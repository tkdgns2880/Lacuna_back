package LacunaMatata.Lacuna.dto.response.user.mbti;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespMbtiSurveyResultDto {
    private int mbtiResultId;
    private String mbtiResultCategoryName;
    private String mbtiResultTitle;
    private String mbtiResultSummary;
    private String mbtiResultContent;
    private String mbtiResultImg;
}
