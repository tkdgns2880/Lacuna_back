package LacunaMatata.Lacuna.dto.request.user.purchase;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReqOrderConsultingProductItemDto {
    private int id;
    private BigDecimal amount;
    private int quantity;
}
