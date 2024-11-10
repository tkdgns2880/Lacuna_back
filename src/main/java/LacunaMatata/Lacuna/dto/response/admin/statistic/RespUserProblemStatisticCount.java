package LacunaMatata.Lacuna.dto.response.admin.statistic;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespUserProblemStatisticCount {
    private Integer rankNumber;
    private Integer skinProblemType;
    private Integer mbtiSkinConcernId;
    private String mbtiSkinConcernName;
    private Integer skinProblemCount;
}
