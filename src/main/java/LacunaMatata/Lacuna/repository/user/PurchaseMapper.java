package LacunaMatata.Lacuna.repository.user;

import LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductDetail.RespConsultingProductDetailDto;
import LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductList.RespProductUpperCategoryDto;
import LacunaMatata.Lacuna.entity.order.Order;
import LacunaMatata.Lacuna.entity.order.OrderItem;
import LacunaMatata.Lacuna.entity.order.Payment;
import LacunaMatata.Lacuna.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface PurchaseMapper {
    /** 회원 - 컨설팅 상품 구매Mapper */
    // 1. 컨설팅 상품 목록 불러오기_2024.11.06
    RespProductUpperCategoryDto getConsultingProductList();
    // 2. 컨설팅 상품 항목 보기_2024.11.06
    RespConsultingProductDetailDto getConsultingProductDetail(int productId);
    // 3-1. 컨설팅 상품 주문하기(구매하기 버튼 클릭) - order_2024.11.06
    int saveOrder(Order order);
    // 3-2. 컨설팅 상품 주문하기(구매하기 버튼 클릭) - orderItem
    int saveOrderItem(OrderItem orderItem);
    // 3-3. 컨설팅 상품 지불 데이터 추가
    int savePayment(Payment payment);
    // 4. 컨설팅 상품 구매 (계좌 이체)_2024.11.11
    int savePaymentAccount();

    /** 공통으로 사용할 Mapper */
    // 1. 상품 ID로 상품 찾기
    Product findProductByProductId(int productId);
}
