package LacunaMatata.Lacuna.dto.response.admin.product;

import LacunaMatata.Lacuna.entity.product.ConsultingContent;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespModifyConsultingProductModalDto {
    RespConsultingDetailDto consultingDetail;
    RespProductRegistModalDto productRegistModal;
}
