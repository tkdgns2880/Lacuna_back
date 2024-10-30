package LacunaMatata.Lacuna.dto.response.admin.mbti;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespMbtiCategoryFilterDto {
    private int mbtiCategoryId;
    private String mbtiCategoryName;
}
