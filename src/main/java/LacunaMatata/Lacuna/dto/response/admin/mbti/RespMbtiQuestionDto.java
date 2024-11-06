package LacunaMatata.Lacuna.dto.response.admin.mbti;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RespMbtiQuestionDto {
    private int mbtiId;
    private int mbtiCategoryId;
    private String mbtiCategoryName;
    private String mbtiCode;
    private String mbtiTitle;
    private String mbtiImg;

    private List<RespMbtiOptionListDto> mbtiOptionList;
}
