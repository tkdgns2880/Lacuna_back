package LacunaMatata.Lacuna.dto.request.user.purchase;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ReqOrderConsultingProductDto {
    private String paymentApproveId;
    private String paymentMethod;
    private BigDecimal totalAmount;
    private List<ReqOrderConsultingProductItemDto> products;
    private String paymentStatus;
    private String email;
}
