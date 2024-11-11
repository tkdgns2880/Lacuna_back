package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.dto.response.admin.order.RespGetOrderDetailDto;
import LacunaMatata.Lacuna.entity.order.Order;
import LacunaMatata.Lacuna.entity.order.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderManageMapper {

    /** orderManage(회원 주문 관리) 관련 Mapper */
    // 1. 회원 주문 목록 출력_2024.10.30
    List<Order> getOrderList(Map<String, Object> params);
    // 2. 회원 주문 상태 출력(필터)_2024.10.31
    List<Order> getOrderStatusFilter();
    // 3. 회원 결제 항목 상세 출력_2024.11.01
    Payment getPaymentDetail(int paymentId);
    // 4-1. 회원 결제 취소(시스템 결제)_2024.11.01 - put
    int cancelSystemPayment(int paymentId);
    // 4-2. 회원 주문 취소(시스템 결제)_2024.11.01 - put
    int cancelSystemOrder(int paymentId);
    // 5-1. 회원 결제 취소(계좌이체)_2024.11.01 - insert
    int cancelAccountPayment(Map<String, Object> params);
    // 5-2. 회원 주문 취소(계좌이체)_2024.11.01 - put
    int cancelAccountOrder(int orderId);
    // 6-1. 회원 결제 승인(계좌이체)_2024.11.01 // 없앰
//    int approveAccountPayment(Map<String, Object> params);
    // 6-1. 회원 결제 승인 (계좌이체)_2024.11.11
    int approveAccountPayment(int orderId);
    // 6-2. 회원 결제 승인 -> 주문 정보 수정(pending -> complete)_2024.11.01
    int approveAccountOrder(int orderId);
    // 7. 주문 항목 단일 삭제_2024.11.01
    int deleteOrder(int orderId);
    // 8. 주문 항목 복수 삭제_2024.11.01
    int deleteOrderList(List<Integer> orderIdList);

    /** 공통으로 쓸 Mapper */
    // 1. 사용자 주문 항목 상세 출력_2024.11.01
    RespGetOrderDetailDto findOrderById(int orderId);
    // 주문 관리 모달창 데이터
    Order getOrder (int orderId);
    // 지불 금액 가져오기
    Payment getPaymentAmount(int orderId);

}
