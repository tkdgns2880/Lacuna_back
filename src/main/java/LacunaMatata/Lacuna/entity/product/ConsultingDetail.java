package LacunaMatata.Lacuna.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultingDetail {
    private int consultingDetailId;
    private int consultingDetailProductId; // productId
    private int consultingDetailContentId; // consultingContentId
    private int repeatCount;
    private String description;
    private String etc;
}
