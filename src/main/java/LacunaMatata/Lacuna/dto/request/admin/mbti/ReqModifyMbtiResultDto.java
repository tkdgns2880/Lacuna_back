package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;

@Data
public class ReqModifyMbtiResultDto {
    private String mbtiResultTitle;
    private String mbtiResultCategoryName;
    private String mbtiResultImg;
    private String mbtiResultSummary;
    private String mbtiResultContent;
    private int mbtiResultStatus;
}
