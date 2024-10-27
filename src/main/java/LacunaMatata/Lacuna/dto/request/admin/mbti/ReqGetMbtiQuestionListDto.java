package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;

@Data
public class ReqGetMbtiQuestionListDto {
    private String filter;
    private String option;
    private String inputValue;
    private int page;
    private int limit;
}
