package LacunaMatata.Lacuna.dto.response.admin.mbti;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespCountAndMbtiQuestionDto {
    private int totalCount;
    private List<RespMbtiQuestionListDto> mbtiQuestionList;
}
