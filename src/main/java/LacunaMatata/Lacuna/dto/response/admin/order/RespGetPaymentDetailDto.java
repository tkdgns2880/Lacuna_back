package LacunaMatata.Lacuna.dto.response.admin.order;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
public class RespGetPaymentDetailDto {
    private int paymentId;
    private String paymentApproveId;
    private String name;
    private String paymentMethod;
    private BigDecimal amount;
    private String paymentStatus;
    private LocalDateTime createdDate;
}
