package LacunaMatata.Lacuna.entity.solution;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolutionDetail {

    private int solutionDetailId;
    private int solutionCategoryId;
    private int solutionDetailProductLowerCategoryId;
    private int solutionDetailProductId;
    private int order;
    private String scope;
    private String amount;
    private int usageCount;
}
