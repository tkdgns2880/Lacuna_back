package LacunaMatata.Lacuna.dto.response.admin.mbti;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespGetMbtiResultDto {
    private int mbtiResultId;
    private String mbtiResultTitle;
    private String mbtiResultCategoryName;
    private String mbtiResultImg;
    private String mbtiResultSummary;
    private String mbtiResultContent;
}
