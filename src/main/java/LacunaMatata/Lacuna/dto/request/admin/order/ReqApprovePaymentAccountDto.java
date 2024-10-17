package LacunaMatata.Lacuna.dto.request.admin.order;

import lombok.Data;

@Data
public class ReqApprovePaymentAccountDto {
    private int orderId;
    private int amount;
}
