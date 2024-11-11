package LacunaMatata.Lacuna.service.user;

import LacunaMatata.Lacuna.dto.request.user.auth.ReqAuthEmailDto;
import LacunaMatata.Lacuna.dto.request.user.purchase.ReqOrderConsultingProductDto;
import LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductDetail.RespConsultingProductDetailDto;
import LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductList.RespConsultingListDto;
import LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductList.RespConsultingProductDto;
import LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductList.RespProductLowerCategoryDto;
import LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductList.RespProductUpperCategoryDto;
import LacunaMatata.Lacuna.entity.order.Order;
import LacunaMatata.Lacuna.entity.order.OrderItem;
import LacunaMatata.Lacuna.entity.order.Payment;
import LacunaMatata.Lacuna.entity.product.Product;
import LacunaMatata.Lacuna.repository.user.PurchaseMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import LacunaMatata.Lacuna.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseService {

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private AuthService authService;

    @Autowired
    private PurchaseMapper purchaseMapper;

    // 회원 컨설팅 상품 목록 출력
    public List<RespConsultingListDto> getConsultingProductList() {
        RespProductUpperCategoryDto productUpperCategory = purchaseMapper.getConsultingProductList();
        List<RespConsultingListDto> consultingProductList = new ArrayList<>();
        for(RespProductLowerCategoryDto resp : productUpperCategory.getProductLowerCategory()) {
            for(RespConsultingProductDto consulting : resp.getConsultingProduct()) {
                RespConsultingListDto consultingProduct = RespConsultingListDto.builder()
                        .productId(consulting.getProductId())
                        .productName(consulting.getProductName())
                        .subtitle(consulting.getSubtitle())
                        .price(consulting.getPrice())
                        .promotionPrice(consulting.getPromotionPrice())
                        .description(consulting.getDescription())
                        .build();
                consultingProductList.add(consultingProduct);
            }
        }

        return consultingProductList;
    }

    // 회원 컨설팅 상품 항목 자세히 보기
    public RespConsultingProductDetailDto getConsultingProductDetail(int productId) {
        RespConsultingProductDetailDto consultingProduct = purchaseMapper.getConsultingProductDetail(productId);
        return consultingProduct;
    }

    // 회원 컨설팅 상품 구매하기 누르기 - 시스템 결제 계좌이체 동일
    public void orderConsultingProduct(ReqOrderConsultingProductDto dto) {
        PrincipalUser principalUser =
                (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getId();
        int productId = dto.getProductId();

        Product product = purchaseMapper.findProductByProductId(productId);
        BigDecimal itemPrice = product.getPrice();
        BigDecimal price = itemPrice.multiply(BigDecimal.valueOf(dto.getAmount()));

        Order order = Order.builder()
                .orderUserId(userId)
                .totalAmount(price)
                .status(dto.getPaymentStatus())
                .build();

        purchaseMapper.saveOrder(order);

        OrderItem orderItem = OrderItem.builder()
                .orderId(order.getOrderId())
                .orderProductId(productId)
                .quantity(dto.getAmount())
                .priceAtPurchase(price)
                .build();
        purchaseMapper.saveOrderItem(orderItem);

        LocalDateTime now = LocalDateTime.now();
        String paymentApproveId = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        Payment payment = Payment.builder()
                .paymentOrderId(order.getOrderId())
                .paymentApproveId(paymentApproveId)
                .paymentMethod(dto.getPaymentMethod())
                .paymentStatus(dto.getPaymentStatus())
                .amount(price)
                .build();

        // 결제 등급 수정

        String toEmail = dto.getEmail();

        if(toEmail == null) {
            return;
        }

        // 이메일
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<div style='display:flex;justify-content:center;align-items:center;flex-direction:column;"
                + "width:400px'>");
        htmlContent.append("<h2>Lacuna 회원님이 주문하신 상품의 정보 입니다.</h2>");
        htmlContent.append("<h3>주문 상품</h3>");
        htmlContent.append("</div>");

        authService.send(toEmail, "Lacuna 컨설팅 주문 정보 이메일 발송 ", htmlContent.toString());
    }
}
