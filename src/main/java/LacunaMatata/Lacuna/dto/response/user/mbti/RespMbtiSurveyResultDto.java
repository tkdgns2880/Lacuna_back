package LacunaMatata.Lacuna.dto.response.user.mbti;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespMbtiSurveyResultDto {
    private int mbtiResultId;
    private String mbtiResultCategoryName;
    private String mbtiResultTitle;
    private String mbtiResultSummary;
    private String mbtiResultContent;
    private String mbtiResultImg;
    private int mbtiResultStatus;

    private int totalSubject;
    private int subject;
}
