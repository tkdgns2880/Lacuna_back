package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.Data;

import java.util.List;

@Data
public class ReqRegisterMbtiQuestionDto {
    private String mbtiCategoryName;
    private String mbtiCode;
    private String mbtiTitle;
    private List<String> optionName;
    private List<Integer> optionScore;
}
