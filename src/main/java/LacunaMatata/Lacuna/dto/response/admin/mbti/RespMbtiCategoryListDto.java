package LacunaMatata.Lacuna.dto.response.admin.mbti;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class RespMbtiCategoryListDto {
    private int mbtiCategoryId;
    private String mbtiCategoryName;
    private String name;
    private LocalDateTime createdDate;
}
