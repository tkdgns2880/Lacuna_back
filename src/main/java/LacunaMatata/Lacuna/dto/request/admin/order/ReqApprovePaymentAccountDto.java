package LacunaMatata.Lacuna.dto.request.admin.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReqApprovePaymentAccountDto {
    private int orderId;
    private BigDecimal amount;
}
