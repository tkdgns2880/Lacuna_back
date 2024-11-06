package LacunaMatata.Lacuna.dto.response.admin.mbti;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespCountAndMbtiCategoryDto {
    private int totalCount;
    private List<RespMbtiCategoryListDto> mbtiCategoryList;
}
