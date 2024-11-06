package LacunaMatata.Lacuna.dto.response.user.purchase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespConsultingDetailProductDto {
    private int consultingDetailId;
    private int consultingDetailContentId;
    private int repeatCount;
    private String name;
}
