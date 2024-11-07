package LacunaMatata.Lacuna.dto.response.user.mbti;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespMbtiCategoryIdDto {
    private int mbtiCategoryId;
    private List<RespMbtiOptionIdDto> mbti;
}
