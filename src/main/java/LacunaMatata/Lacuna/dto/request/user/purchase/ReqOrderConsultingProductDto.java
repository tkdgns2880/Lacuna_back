package LacunaMatata.Lacuna.dto.request.user.purchase;

import lombok.Data;

@Data
public class ReqOrderConsultingProductDto {
    private int productId;
    private String paymentApproveId;
    private String paymentMethod;
    private int amount;
    private String paymentStatus;
    private String email;
}
