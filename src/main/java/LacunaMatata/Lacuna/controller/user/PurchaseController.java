package LacunaMatata.Lacuna.controller.user;

import LacunaMatata.Lacuna.dto.request.user.purchase.ReqOrderConsultingProductDto;
import LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductDetail.RespConsultingProductDetailDto;
import LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductList.RespConsultingListDto;
import LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductList.RespProductUpperCategoryDto;
import LacunaMatata.Lacuna.service.user.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Api(tags = "PurchaseController")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // 컨설팅 상품 소개 페이지 - 컨설팅 상품 목록 출력 - 비회원도 가능
    @GetMapping("/product/consulting")
    @ApiOperation(value = "getProductListApi")
    public ResponseEntity<?> getConsultingProductList() {
        List<RespConsultingListDto> consultingProduct = purchaseService.getConsultingProductList();
        return ResponseEntity.ok().body(consultingProduct);
    }

    // 회원 컨설팅 상품 상세 보기 - 회원만 가능
    @GetMapping("/user/product/detail/{productId}")
    @ApiOperation(value = "getConsultingProductDetailApi")
    public ResponseEntity<?> getConsultingProductDetail(@PathVariable int productId) {
        RespConsultingProductDetailDto consultingProduct = purchaseService.getConsultingProductDetail(productId);
        return ResponseEntity.ok().body(consultingProduct);
    }

    // 회원 구매하기 버튼 누르기 - 주문 항목 생성 (시스템 결제)
    @PostMapping("/user/product/order")
    public ResponseEntity<?> orderConsultingProduct(@RequestBody ReqOrderConsultingProductDto dto) throws Exception {
        purchaseService.orderConsultingProduct(dto);
        return ResponseEntity.ok().body(true);
    }

}
