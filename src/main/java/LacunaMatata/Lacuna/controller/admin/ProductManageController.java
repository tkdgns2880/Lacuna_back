package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.dto.request.admin.product.*;
import LacunaMatata.Lacuna.dto.response.admin.product.RespLowerProductCategoryDto;
import LacunaMatata.Lacuna.dto.response.admin.product.RespProductDetailDto;
import LacunaMatata.Lacuna.dto.response.admin.product.RespProductDto;
import LacunaMatata.Lacuna.dto.response.admin.product.RespUpperProductCategoryDto;
import LacunaMatata.Lacuna.service.admin.ProductManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/************************************************
 * version: 1.0.4                               *
 * author: 손경태                                *
 * description: AdminProductController() - 세팅  *
 * createDate: 2024-10-16                       *
 * updateDate: 2024-10-16                       *
 ************************************************/
@RestController
@Slf4j
@Api(tags = "ProductManageController")
@RequestMapping("/api/v1/admin/product")
public class ProductManageController {

    @Autowired
    private ProductManageService productManageService;

    // 상품 상위 분류 리스트 출력 - 완료
    @GetMapping("/upper/list")
    @ApiOperation(value = "getUpperProductListApi")
    public ResponseEntity<?> getUpperProductList() {
        List<RespUpperProductCategoryDto> respUpperProductCategoryList =
                productManageService.getProductUpperCategory();
        return ResponseEntity.ok().body(respUpperProductCategoryList);
    }

    // 상품 상위 분류 카테고리 등록
    @PostMapping("/upper/register")
    @ApiOperation(value = "registerUpperProductApi")
    public ResponseEntity<?> registerUpperProduct(@RequestBody ReqRegisterUpperProductCategoryDto dto) {
        productManageService.registerProductUpperCategory(dto);
        return ResponseEntity.ok().body(true);
    }

    // 상품 상위 분류 항목 출력
    @GetMapping("/upper/{upperId}")
    @ApiOperation(value = "getUpperProductApi")
    public ResponseEntity<?> getUpperProduct(@PathVariable int upperId) {
        RespUpperProductCategoryDto respUpperCategory = productManageService.getProductUpper(upperId);
        return ResponseEntity.ok().body(respUpperCategory);
    }

    // 상품 상위 분류 카테고리 수정
    @PutMapping("/upper/modify")
    @ApiOperation(value = "modifyUpperProductApi")
    public ResponseEntity<?> modifyUpperProduct(@RequestBody ReqModifyUpperProductDto dto) {
        productManageService.modifyProductUpperCategory(dto);
        return ResponseEntity.ok().body(true);
    }

    // 상품 상위 분류 카테고리 삭제
    @DeleteMapping("/upper/delete/{upperId}")
    @ApiOperation(value = "deleteUpperProductApi")
    public ResponseEntity<?> deleteUpperProduct(@PathVariable int upperId) {
        productManageService.deleteProductUpperCategory(upperId);
        return ResponseEntity.ok().body(true);
    }

    // 상품 상위 분류 카테고리 복수개 삭제
    @DeleteMapping("/upper/delete")
    @ApiOperation(value = "deleteUpperProductListApi")
    public ResponseEntity<?> deleteUpperProductList(@RequestBody ReqDeleteUpperProductCategoryListDto dto) {
        productManageService.deleteProductUpperCategoryList(dto);
        return ResponseEntity.ok().body(null);
    }

    // 상품 하위 분류 리스트 출력
    @GetMapping("/lower/list/{upperId}")
    @ApiOperation(value = "getLowerProductListApi")
    public ResponseEntity<?> getLowerProductList(@PathVariable int upperId) {
        List<RespLowerProductCategoryDto> respLowerProductCategoryList =
                productManageService.getProductlowerCategory(upperId);
        return ResponseEntity.ok().body(respLowerProductCategoryList);
    }

    // 상품 하위 분류 카테고리 등록
    @PostMapping("/lower/register/{upperId}")
    @ApiOperation(value = "registerLowerProductApi")
    public ResponseEntity<?> registerLowerProduct(@RequestBody ReqRegisterLowerProductCategoryDto dto, @PathVariable int upperId) {
        productManageService.registerProductlowerCategory(dto, upperId);
        return ResponseEntity.ok().body(null);
    }

    // 상품 하위 분류 카테고리 항목 출력
    @GetMapping("/lower/{lowerId}")
    @ApiOperation(value = "getLowerProductApi")
    public ResponseEntity<?> getLowerProduct(@PathVariable int lowerId) {
        RespLowerProductCategoryDto respLowerCategory = productManageService.getProductLower(lowerId);
        return ResponseEntity.ok().body(respLowerCategory);
    }

    // 상품 하위 분류 카테고리 수정
    @PutMapping("/lower/modify")
    @ApiOperation(value = "modifyLowerProductApi")
    public ResponseEntity<?> modifyLowerProduct(@RequestBody ReqModifyLowerProductCategoryDto dto) {
        productManageService.modifyProductlowerCategory(dto);
        return ResponseEntity.ok().body(true);
    }

    // 상품 하위 분류 카테고리 삭제
    @DeleteMapping("/lower/delete/{lowerId}")
    @ApiOperation(value = "deleteLowerProductApi")
    public ResponseEntity<?> deleteLowerProduct(@PathVariable int lowerId) {
        productManageService.deleteProductlowerCategory(lowerId);
        return ResponseEntity.ok().body(true);
    }

    // 상품 하위 분류 카테고리 복수개 삭제
    @DeleteMapping("/lower/delete")
    @ApiOperation(value = "deleteLowerProductListApi")
    public ResponseEntity<?> deleteLowerProductList(@RequestBody ReqDeleteLowerProductCategoryListDto dto) {
        productManageService.deleteProductlowerCategoryList(dto);
        return ResponseEntity.ok().body(null);
    }

    // 상품 리스트 출력
    @GetMapping("/list")
    @ApiOperation(value = "getProductListApi")
    public ResponseEntity<?> getProductList(@RequestBody ReqGetProductListDto dto) {
        List<RespProductDto> productList = productManageService.getProducts(dto);
        return ResponseEntity.ok().body(productList);
    }

    // 상품 등록
    @PostMapping("/register")
    @ApiOperation(value = "registerProductApi")
    public ResponseEntity<?> registerProduct(@RequestBody ReqRegisterProductDto dto) {
        productManageService.registerProduct(dto);
        return ResponseEntity.ok().body(null);
    }

    // 상품 항목 출력
    @GetMapping("/{productId}")
    @ApiOperation(value = "getProductApi")
    public ResponseEntity<?> getProduct(@PathVariable int productId) {
        RespProductDetailDto productDetail =
                productManageService.getProductDetail(productId);
        return ResponseEntity.ok().body(productDetail);
    }

    // 상품 수정
    @PutMapping("/modify")
    @ApiOperation(value = "modifyProductApi")
    public ResponseEntity<?> modifyProduct(@RequestBody ReqModifyProductDto dto) {
        productManageService.modifyProduct(dto);
        return ResponseEntity.ok().body(null);
    }

    // 상품 삭제
    @DeleteMapping("/delete/{productId}")
    @ApiOperation(value = "deleteProductApi")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId) {
        productManageService.deleteProduct(productId);
        return ResponseEntity.ok().body(true);
    }

    // 상품 복수개 삭제
    @DeleteMapping("/delete")
    @ApiOperation(value = "deleteProductListApi")
    public ResponseEntity<?> deleteProductList(@RequestBody ReqDeleteProductDto dto) {
        productManageService.deleteProductList(dto);
        return ResponseEntity.ok().body(null);
    }
}
