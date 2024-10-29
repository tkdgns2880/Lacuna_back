package LacunaMatata.Lacuna.controller.admin;

import LacunaMatata.Lacuna.dto.request.admin.product.*;
import LacunaMatata.Lacuna.dto.response.admin.product.*;
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
        List<RespUpperProductCategoryListDto> respUpperProductCategoryList =
                productManageService.getProductUpperCategory();
        return ResponseEntity.ok().body(respUpperProductCategoryList);
    }

    // 상품 상위 분류 카테고리 등록
    @PostMapping("/upper/regist")
    @ApiOperation(value = "registUpperProductApi")
    public ResponseEntity<?> registUpperProduct(@RequestBody ReqRegistUpperProductCategoryDto dto) {
        productManageService.registProductUpperCategory(dto);
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
    @PutMapping("/upper/modify/{upperId}")
    @ApiOperation(value = "modifyUpperProductApi")
    public ResponseEntity<?> modifyUpperProduct(@RequestBody ReqModifyUpperProductDto dto, @PathVariable int upperId) {
        productManageService.modifyProductUpperCategory(dto, upperId);
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
        List<RespLowerProductCategoryListDto> respLowerProductCategoryList =
                productManageService.getProductlowerCategory(upperId);
        return ResponseEntity.ok().body(respLowerProductCategoryList);
    }

    // 상품 하위 분류 카테고리 등록
    @PostMapping("/lower/regist/{upperId}")
    @ApiOperation(value = "registLowerProductApi")
    public ResponseEntity<?> registLowerProduct(@RequestBody ReqRegistLowerProductCategoryDto dto, @PathVariable int upperId) {
        productManageService.registProductlowerCategory(dto, upperId);
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
    @PutMapping("/lower/modify/{lowerId}")
    @ApiOperation(value = "modifyLowerProductApi")
    public ResponseEntity<?> modifyLowerProduct(@RequestBody ReqModifyLowerProductCategoryDto dto, @PathVariable int lowerId) {
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
    public ResponseEntity<?> getProductList(ReqGetProductListDto dto) {
        System.out.println("요청 데이터: " + dto);
        List<RespProductDto> productList = productManageService.getProducts(dto);
        return ResponseEntity.ok().body(productList);
    }

    // 상품 등록
    @PostMapping("/regist")
    @ApiOperation(value = "registProductApi")
    public ResponseEntity<?> registProduct(@RequestBody ReqRegistProductDto dto) {
        productManageService.registProduct(dto);
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
    @PutMapping("/modify/{productId}")
    @ApiOperation(value = "modifyProductApi")
    public ResponseEntity<?> modifyProduct(@RequestBody ReqModifyProductDto dto, @PathVariable int productId) {
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
    @GetMapping("/upper/filter")
    public ResponseEntity<?> getUpperProductFilter() {
        List<RespUpperProductCategoryDto> upperFilter = productManageService.getUpperProductFilter();
        return ResponseEntity.ok().body(upperFilter);
    }
    @GetMapping("/lower/filter/{upperId}")
    public ResponseEntity<?> getLowerProductFilter(@PathVariable int upperId) {
        List<RespLowerProductCategoryDto> lowerFilter = productManageService.getLowerProductFilter(upperId);
        return ResponseEntity.ok().body(lowerFilter);
    }
}
