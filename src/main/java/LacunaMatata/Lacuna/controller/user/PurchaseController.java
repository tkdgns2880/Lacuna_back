package LacunaMatata.Lacuna.controller.user;

import LacunaMatata.Lacuna.dto.response.user.purchase.RespProductUpperCategoryDto;
import LacunaMatata.Lacuna.service.user.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@Api(tags = "PurchaseController")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // 컨설팅 상품 소개 페이지 - 컨설팅 상품 목록 출력
    @GetMapping("/product/consulting")
    @ApiOperation(value = "getProductListApi")
    public ResponseEntity<?> getConsultingProductList() {
        RespProductUpperCategoryDto productUpperCategory = purchaseService.getConsultingProductList();
        return ResponseEntity.ok().body(productUpperCategory);
    }

    // 회원 컨설팅 상품 상세 보기
    
}
