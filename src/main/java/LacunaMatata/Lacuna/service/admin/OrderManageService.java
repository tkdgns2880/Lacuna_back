package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.order.ReqGetOrderListDto;
import LacunaMatata.Lacuna.dto.response.admin.order.RespCountAndOderListDto;
import LacunaMatata.Lacuna.dto.response.admin.order.RespGetOrderListDto;
import LacunaMatata.Lacuna.entity.order.Order;
import LacunaMatata.Lacuna.repository.admin.OrderManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderManageService {

    @Autowired
    private OrderManageMapper orderManageMapper;

    // 회원 주문 정보 리스트 출력
    public RespCountAndOderListDto getOrderList(ReqGetOrderListDto dto) {
        int startIndex = (dto.getPage() - 1) * dto.getLimit();
        Map<String, Object> params = Map.of(
                "filter", dto.getFilter(),
                "option", dto.getOption(),
                "searchValue", dto.getSearchValue(),
                "startIndex", startIndex,
                "limit", dto.getLimit()
        );
        List<Order> orderList = orderManageMapper.getOrderList(params);
        List<RespGetOrderListDto> respGetOrderListDtos = new ArrayList<>();
        for(Order order : orderList) {
            RespGetOrderListDto respGetOrderListDto = RespGetOrderListDto.builder()
                    .orderId(order.getOrderId())
                    .name(order.getName())
                    .roleName(order.getRoleName())
                    .totalAmount(order.getTotalAmount())
                    .createdDate(order.getCreatedDate())
                    .status(order.getStatus())
                    .build();
            respGetOrderListDtos.add(respGetOrderListDto);
        }
        RespCountAndOderListDto respCountAndOderListDto = RespCountAndOderListDto.builder()
                .totalCount(respGetOrderListDtos.size())
                .orderList(respGetOrderListDtos)
                .build();

        return respCountAndOderListDto;
    }

    // 회원 주문 항목 상세 출력
    public void getOrderDetail() {

    }

    // 회원 결제 항목 상세 출력
    public void getPaymentDetail() {

    }

    // 회원 결제 취소하기 (결제 취소하기)
    public void cancelSystemOrder() {

    }

    // 주문 수정 - 회원 결제 취소하기 (계좌 이체)
    public void cancelAccountOrder() {

    }

    // 주문 수정 - 회원 결제 승인하기 (계좌 이체)
    public void approveAccountOrder() {

    }

    // 회원 주문 항목 삭제
    public void deleteOrder() {

    }

    // 회원 주문 항목 복수개 삭제
    public void deleteOrderList() {

    }
}
