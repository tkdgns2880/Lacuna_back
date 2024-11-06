package LacunaMatata.Lacuna.dto.response.admin.mbti;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespMbtiOptionListDto {
    private String optionName;
    private int optionScore;
}
