package LacunaMatata.Lacuna.dto.request.admin.mbti;

import LacunaMatata.Lacuna.entity.mbti.MbtiResult;
import lombok.Data;

@Data
public class ReqRegisteMbtiResultDto {
    private String mbtiResultTitle;
    private String mbtiResultCategoryName;
    private String mbtiResultImg;
    private String mbtiResultSummary;
    private String mbtiResultContent;
    private int mbtiResultStatus;

    public MbtiResult toMbtiResult() {
        return MbtiResult.builder()
                .mbtiResultTitle(mbtiResultTitle)
                .mbtiResultCategoryName(mbtiResultCategoryName)
                .mbtiResultImg(mbtiResultImg)
                .mbtiResultSummary(mbtiResultSummary)
                .mbtiResultContent(mbtiResultContent)
                .mbtiResultStatus(mbtiResultStatus)
                .build();
    }
}
