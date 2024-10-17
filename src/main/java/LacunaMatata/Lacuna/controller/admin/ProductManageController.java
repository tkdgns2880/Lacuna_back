package LacunaMatata.Lacuna.controller.admin;

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
@RequestMapping("/auth/admin/product")
public class ProductManageController {

    // 상품 상위 분류 리스트 출력
    @GetMapping("/upper")
    public ResponseEntity<?> getUpperProductList() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 상위 분류 카테고리 등록
    @PostMapping("/upper/register")
    public ResponseEntity<?> registerUpperProduct() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 상위 분류 카테고리 수정
    @PutMapping("/upper/modify")
    public ResponseEntity<?> modifyUpperProduct() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 상위 분류 카테고리 삭제
    @DeleteMapping("/upper/delete/{upperId}")
    public ResponseEntity<?> deleteUpperProduct() {
        return ResponseEntity.ok().body(null);
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
    public ResponseEntity<?> registerLowerProduct() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 하위 분류 카테고리 수정
    @PutMapping("/lower/modify")
    public ResponseEntity<?> modifyLowerProduct() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 하위 분류 카테고리 삭제
    @DeleteMapping("/lower/delete/{lowerId}")
    public ResponseEntity<?> deleteLowerProduct() {
        return ResponseEntity.ok().body(null);
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
    public ResponseEntity<?> deleteProduct() {
        return ResponseEntity.ok().body(null);
    }

    // 상품 복수개 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProductList() {
        return ResponseEntity.ok().body(null);
    }
}
