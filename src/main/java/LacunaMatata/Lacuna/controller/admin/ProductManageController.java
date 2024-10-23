package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.dto.request.admin.product.ReqModifyLowerProductCategoryDto;
import LacunaMatata.Lacuna.dto.request.admin.product.ReqModifyUpperProductDto;
import LacunaMatata.Lacuna.dto.request.admin.product.ReqRegisterLowerProductCategoryDto;
import LacunaMatata.Lacuna.dto.request.admin.product.ReqRegisterUpperProductCategoryDto;
import LacunaMatata.Lacuna.service.admin.ProductManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/************************************************
 * version: 1.0.4                               *
 * author: 손경태                                *
 * description: AdminProductController() - 세팅  *
 * createDate: 2024-10-16                       *
 * updateDate: 2024-10-16                       *
 ************************************************/
@RestController
@Slf4j
@RequestMapping("/auth/admin/product")
public class ProductManageController {

    @Autowired
    private ProductManageService productManageService;

    // 상품 상위 분류 리스트 출력
    @GetMapping("/upper")
    public ResponseEntity<?> getUpperProductList() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 상위 분류 카테고리 등록
    @PostMapping("/upper/register")
    public ResponseEntity<?> registerUpperProduct(@RequestBody ReqRegisterUpperProductCategoryDto dto) {
        productManageService.registerProductUpperCategory(dto);
        return ResponseEntity.ok().body(true);
    }

    // 상품 상위 분류 카테고리 수정
    @PutMapping("/upper/modify")
    public ResponseEntity<?> modifyUpperProduct(@RequestBody ReqModifyUpperProductDto dto) {
        productManageService.modifyProductUpperCategory(dto);
        return ResponseEntity.ok().body(true);
    }

    // 상품 상위 분류 카테고리 삭제
    @DeleteMapping("/upper/delete/{upperId}")
    public ResponseEntity<?> deleteUpperProduct(@PathVariable int upperId) {
        productManageService.deleteProductUpperCategory(upperId);
        return ResponseEntity.ok().body(true);
    }

    // 상품 상위 분류 카테고리 복수개 삭제
    @DeleteMapping("/upper/delete")
    public ResponseEntity<?> deleteUpperProductList() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 하위 분류 리스트 출력
    @GetMapping("/lower/{upperId}")
    public ResponseEntity<?> getLowerProductList() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 하위 분류 카테고리 등록
    @PostMapping("/lower/register/{upperId}")
    public ResponseEntity<?> registerLowerProduct(@RequestBody ReqRegisterLowerProductCategoryDto dto) {
        productManageService.registerProductlowerCategory(dto);
        return ResponseEntity.ok().body(null);
    }

    // 상품 하위 분류 카테고리 수정
    @PutMapping("/lower/modify")
    public ResponseEntity<?> modifyLowerProduct(@RequestBody ReqModifyLowerProductCategoryDto dto) {
        productManageService.modifyProductlowerCategory(dto);
        return ResponseEntity.ok().body(true);
    }

    // 상품 하위 분류 카테고리 삭제
    @DeleteMapping("/lower/delete/{lowerId}")
    public ResponseEntity<?> deleteLowerProduct(@PathVariable int lowerId) {
        productManageService.deleteProductlowerCategory(lowerId);
        return ResponseEntity.ok().body(true);
    }

    // 상품 하위 분류 카테고리 복수개 삭제
    @DeleteMapping("/lower/delete")
    public ResponseEntity<?> deleteLowerProductList() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 리스트 출력
    @GetMapping("/list")
    public ResponseEntity<?> getProductList() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 등록
    @PostMapping("/register")
    public ResponseEntity<?> registerProduct() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 수정
    @PutMapping("/modify")
    public ResponseEntity<?> modifyProduct() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 삭제
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId) {
        productManageService.deleteProduct(productId);
        return ResponseEntity.ok().body(true);
    }

    // 상품 복수개 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProductList() {
        return ResponseEntity.ok().body(null);
    }
}
