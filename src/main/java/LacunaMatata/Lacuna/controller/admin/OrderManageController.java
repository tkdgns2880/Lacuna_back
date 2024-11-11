package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.dto.request.admin.order.*;
import LacunaMatata.Lacuna.dto.response.admin.order.RespCountAndOderListDto;
import LacunaMatata.Lacuna.dto.response.admin.order.RespGetOrderDetailDto;
import LacunaMatata.Lacuna.dto.response.admin.order.RespGetOrderStatusFilterDto;
import LacunaMatata.Lacuna.dto.response.admin.order.RespGetPaymentDetailDto;
import LacunaMatata.Lacuna.service.admin.OrderManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/************************************************
 * version: 1.0.4                               *
 * author: 손경태                                *
 * description: AdminOrderController() - 세팅    *
 * createDate: 2024-10-16                       *
 * updateDate: 2024-10-16                       *
 ************************************************/
@RestController
@RequestMapping("/api/v1/admin/order")
@Api(tags = {"OrderManageController"})
public class OrderManageController {

    @Autowired
    private OrderManageService orderManageService;

    // 회원 주문 리스트 출력
    @GetMapping("/list")
    @ApiOperation(value = "getOrderListApi")
    public ResponseEntity<?> getOrderList(ReqGetOrderListDto dto) {
        RespCountAndOderListDto respCountAndOderListDto = orderManageService.getOrderList(dto);
        return ResponseEntity.ok().body(respCountAndOderListDto);
    }

    // 회원 주문 상태 목록 출력(필터)
    @GetMapping("/status/filter")
    @ApiOperation(value = "getOrderStatusFilterApi") // test 완료
    public ResponseEntity<?> getOrderStatusFilter() {
        List<RespGetOrderStatusFilterDto> orderFilter = orderManageService.getOrderStatusFilter();
        return ResponseEntity.ok().body(orderFilter);
    }

    // 회원 주문 항목 상세 출력
    @GetMapping("/order/detail/{orderId}")
    @ApiOperation(value = "getOrderDetailApi") // test 완료
    public ResponseEntity<?> getOrderDetail(@PathVariable int orderId) {
        RespGetOrderDetailDto orderDetail = orderManageService.getOrderDetail(orderId);
        return ResponseEntity.ok().body(orderDetail);
    }

    // 회원 결제 항목 상세 출력
    @GetMapping("/payment/detail/{paymentId}")
    @ApiOperation(value = "getPaymentDetailApi") // test 완료
    public ResponseEntity<?> getPaymentDetail(@PathVariable int paymentId) {
        RespGetPaymentDetailDto paymentDetail = orderManageService.getPaymentDetail(paymentId);
        return ResponseEntity.ok().body(paymentDetail);
    }

    // 회원 결제 취소하기(결제 시스템) - 계좌, 시스템 공통
    @PutMapping("/payment/cancel/{paymentId}")
    @ApiOperation(value = "cancelSystemPaymentApi") // test 완료
    public ResponseEntity<?> cancelSystemPayment(@PathVariable int paymentId) {
        orderManageService.cancelSystemOrder(paymentId);
        return ResponseEntity.ok().body(true);
    }
//
//    중복기능
//    // Todo 주문 관리 모달창 데이터 가져오는 API 추가 구축 필요
//    @GetMapping("/modify{orderId}")
//    @ApiOperation(value = "getModifyOrderApi")
//    public ResponseEntity<?> getModifyOrder(@RequestBody ReqGetModifyOrderDto dto, @PathVariable int orderId) {
//        // Todo service, Dto, Repositry 등 구축 필요
//        return ResponseEntity.ok().body(null);
//    }

//    // 주문 수정 - 회원 결제 취소하기(계좌 이체)
//    @PostMapping("/management/transfer/cancel")
//    @ApiOperation(value = "cancelAccountPaymentApi") // test 완료
//    public ResponseEntity<?> cancelAccountPayment(@RequestBody ReqCancelOrderAccountDto dto) {
//        orderManageService.cancelAccountOrder(dto);
//        return ResponseEntity.ok().body(true);
//    }

    // 주문 수정 - 회원 결제 승인하기(계좌 이체)
    @PostMapping("/management/transfer/approve")
    @ApiOperation(value = "approveAccountPaymentApi") // test 완료
    public ResponseEntity<?> approveAccountPayment(@RequestBody ReqApprovePaymentAccountDto dto) throws Exception {
        orderManageService.approveAccountOrder(dto);
        return ResponseEntity.ok().body(true);
    }

    // 회원 주문 항목 삭제
    @DeleteMapping("/order/delete/{orderId}")
    @ApiOperation(value = "deleteOrderApi") // test 완료
    public ResponseEntity<?> deleteOrder(@PathVariable int orderId) {
        orderManageService.deleteOrder(orderId);
        return ResponseEntity.ok().body(true);
    }

    // 회원 주문 항목 복수개 삭제
    @DeleteMapping("/order/delete")
    @ApiOperation(value = "deleteOrderListApi") // test 완료
    public ResponseEntity<?> deleteOrderList(@RequestBody ReqDeleteOrderListDto dto) {
        orderManageService.deleteOrderList(dto);
        return ResponseEntity.ok().body(true);
    }
}