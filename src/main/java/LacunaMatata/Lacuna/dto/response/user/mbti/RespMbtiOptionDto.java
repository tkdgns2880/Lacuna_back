package LacunaMatata.Lacuna.dto.response.user.mbti;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespMbtiOptionDto {
    private int mbtiOptionId;
    private int mbtiId;
    private String optionName;
    private int optionScore;
}
