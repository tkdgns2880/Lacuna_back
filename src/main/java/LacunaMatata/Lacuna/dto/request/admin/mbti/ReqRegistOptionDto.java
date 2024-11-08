package LacunaMatata.Lacuna.dto.request.admin.mbti;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqRegistOptionDto {
    private String optionName;
    private int optionScore;
}
