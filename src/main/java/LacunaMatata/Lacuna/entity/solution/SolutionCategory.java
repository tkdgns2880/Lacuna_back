package LacunaMatata.Lacuna.entity.solution;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolutionCategory {

    private int solutionCategoryId;
    private int solutionCategorySolutionResultId;
    private int solutionCategory;
    private int solutionCategoryConsultingLowerCategoryId;
    private String timeZone;
}
