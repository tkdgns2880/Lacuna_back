package LacunaMatata.Lacuna.dto.response.user.user;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class RespMyMbtiResultDto {
    private int mbtiResultId;
    private String mbtiResultCategoryName;
    private String mbtiResultTitle;
    private String mbtiResultSummary;
    private String mbtiResultContent;
    private String mbtiResultImg;
}
