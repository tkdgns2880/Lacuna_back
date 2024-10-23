package LacunaMatata.Lacuna.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LifestyleResultDetail {
    private int lifestyleResultDetailId;
    private int lifestyleResultId;
    private String lifestyleResultType;
    private String lifestyleResultTitle;
    private String lifestyleResultContent;
}
