package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;

@Data
public class ReqGetMbtiQuestionListDto {
    private int filter;
    private int option;
    private String searchValue;
    private int page;
    private int limit;
}
