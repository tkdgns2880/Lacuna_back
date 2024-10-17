package LacunaMatata.Lacuna.dto.response.admin.mbti;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class RespMbtiQuestionDto {
    private int mbtiId;
    private String mbtiCategoryName;
    private String mbtiTitle;
    private String name;
    private LocalDateTime createdDate;
}
