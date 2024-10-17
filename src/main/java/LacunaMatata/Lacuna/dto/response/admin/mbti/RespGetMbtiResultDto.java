package LacunaMatata.Lacuna.dto.response.admin.mbti;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class RespGetMbtiResultDto {
    private int mbtiResultId;
    private String mbtiResultCategoryName;
    private String mbtiResultTitle;
    private String mbtiResultStatus;
    private String name;
    private LocalDateTime createdDate;
}
