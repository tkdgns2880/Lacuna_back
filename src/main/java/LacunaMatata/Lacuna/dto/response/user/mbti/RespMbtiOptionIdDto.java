package LacunaMatata.Lacuna.dto.response.user.mbti;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespMbtiOptionIdDto {
    private int optionId;
    private int mbtiId;
    private int optionScore;
}
