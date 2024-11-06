package LacunaMatata.Lacuna.entity.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private int orderId;
    private int orderUserId;
    private BigDecimal totalAmount;
    private String status;
    private LocalDateTime createdDate;

    //계산용
    private int totalCount;

    // 조인용
    private String name;
    private String roleName;
    private int paymentId;
    private String paymentMethod;
    private String productName;
    private OrderItem orderItemList;
}
