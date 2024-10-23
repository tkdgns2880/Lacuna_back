package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.product.ReqModifyLowerProductCategoryDto;
import LacunaMatata.Lacuna.dto.request.admin.product.ReqModifyUpperProductDto;
import LacunaMatata.Lacuna.dto.request.admin.product.ReqRegisterLowerProductCategoryDto;
import LacunaMatata.Lacuna.dto.request.admin.product.ReqRegisterUpperProductCategoryDto;
import LacunaMatata.Lacuna.entity.product.Product;
import LacunaMatata.Lacuna.entity.product.ProductUpperCategory;
import LacunaMatata.Lacuna.repository.admin.ProductManageMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductManageService {

    @Autowired
    private ProductManageMapper productManageMapper;

    // 상품 상위 분류 리스트 출력
    public List<Object> getProductUpperCategory() {
        return null;
    }

    // 상품 상위 분류 카테고리 등록
    public void registerProductUpperCategory(ReqRegisterUpperProductCategoryDto dto) {
//        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        productManageMapper.saveProductUpperCategory(dto.getProductUpperCategoryName());
    }

    // 상품 상위 분류 카테고리 수정
    public void modifyProductUpperCategory(ReqModifyUpperProductDto dto) {
        productManageMapper.modifyProductUpperCategory(dto);
    }

    // 상품 상위 분류 카테고리 삭제
    public void deleteProductUpperCategory(int upperId) {
        productManageMapper.deleteUpperProductCategory(upperId);
    }

    // 상품 상위 분류 카테고리 복수개 삭제
    public void deleteProductUpperCategoryList() {

    }

    // 상품 하위 분류 리스트 출력
    public List<Object> getProductlowerCategory() {
        return null;
    }

    // 상품 하위 분류 카테고리 등록
    public void registerProductlowerCategory(ReqRegisterLowerProductCategoryDto dto) {
        productManageMapper.saveProductLowerCategory(dto.getProductLowerCategoryName());
    }

    // 상품 하위 분류 카테고리 수정
    public void modifyProductlowerCategory(ReqModifyLowerProductCategoryDto dto) {
        productManageMapper.modifyProductLowerCategory(dto);
    }

    // 상품 하위 분류 카테고리 삭제
    public void deleteProductlowerCategory(int lowerId) {
        productManageMapper.deleteProductLowerCategory(lowerId);
    }

    // 상품 하위 분류 카테고리 복수개 삭제
    public void deleteProductlowerCategoryList() {

    }

    // 상품 리스트 출력
    public List<Object> getProducts() {
        return null;
    }

    // 상품 등록
    public void registerProduct() {

    }

    // 상품 수정
    public void modifyProduct() {

    }

    // 상품 삭제
    public void deleteProduct(int productId) {
        productManageMapper.deleteProduct(productId);
    }

    // 상품 복수개 삭제
    public void deleteProductList() {

    }
}
