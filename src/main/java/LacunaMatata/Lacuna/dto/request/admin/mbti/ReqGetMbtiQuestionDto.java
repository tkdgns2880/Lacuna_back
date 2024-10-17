package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;

@Data
public class ReqGetMbtiQuestionDto {
    private String option;
    private String code;
    private int page;
    private int limit;
}
