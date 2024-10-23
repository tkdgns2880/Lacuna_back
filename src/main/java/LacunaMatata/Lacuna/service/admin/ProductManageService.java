package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.product.*;
import LacunaMatata.Lacuna.dto.response.admin.product.RespUpperProductCategoryDto;
import LacunaMatata.Lacuna.entity.product.Product;
import LacunaMatata.Lacuna.entity.product.ProductLowerCategory;
import LacunaMatata.Lacuna.entity.product.ProductUpperCategory;
import LacunaMatata.Lacuna.repository.admin.ProductManageMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductManageService {

    @Autowired
    private ProductManageMapper productManageMapper;

    // 상품 상위 분류 리스트 출력
    public List<RespUpperProductCategoryDto> getProductUpperCategory(ReqGetUpperProductCategoryListDto dto) {
        int startIndex = (dto.getPage() - 1) * dto.getLimit();
        Map<String, Object> params = Map.of(
                "startIndex", startIndex,
                "limit", dto.getLimit()
        );
        List<ProductUpperCategory> productUpperCategoryList = productManageMapper.getProductUpperCategoryList(params);
        List<RespUpperProductCategoryDto> productUpperCategory = new ArrayList<>();
        for(ProductUpperCategory productUpperCategoryDto : productUpperCategoryList) {
            RespUpperProductCategoryDto respUpperProductCategoryDto = RespUpperProductCategoryDto.builder()
                    .productUpperCategoryId(productUpperCategoryDto.getProductUpperCategoryId())
                    .productUpperCategoryName(productUpperCategoryDto.getProductUpperCategoryName())
                    .name(productUpperCategoryDto.getUser().getName())
                    .createdDate(productUpperCategoryDto.getCreateDate())
                    .build();
            productUpperCategory.add(respUpperProductCategoryDto);
        }

        return productUpperCategory;
    }

    // 상품 상위 분류 카테고리 등록
    public void registerProductUpperCategory(ReqRegisterUpperProductCategoryDto dto) {

        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerAdminId = principalUser.getId();
        ProductUpperCategory productUpperCategory = ProductUpperCategory.builder()
                .productUpperCategoryName(dto.getProductUpperCategoryName())
                .productUpperCategoryRegisterId(registerAdminId)
                .build();

        productManageMapper.saveProductUpperCategory(productUpperCategory);
    }

    // 상품 상위 분류 카테고리 수정
    public void modifyProductUpperCategory(ReqModifyUpperProductDto dto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerAdminId = principalUser.getId();
        ProductUpperCategory productUpperCategory = ProductUpperCategory.builder()
                .productUpperCategoryId(dto.getProductUpperCategoryId())
                .productUpperCategoryName(dto.getProductUpperCategoryName())
                .productUpperCategoryRegisterId(registerAdminId)
                .build();

        productManageMapper.modifyProductUpperCategory(productUpperCategory);
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
    public void registerProductlowerCategory(ReqRegisterLowerProductCategoryDto dto, int upperId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerAdminId = principalUser.getId();
        ProductLowerCategory productLowerCategory = ProductLowerCategory.builder()
                .productLowerCategoryName(dto.getProductLowerCategoryName())
                .productLowerCategoryRegisterId(registerAdminId)
                .productUpperCategoryId(upperId)
                .build();

        productManageMapper.saveProductLowerCategory(productLowerCategory);
    }

    // 상품 하위 분류 카테고리 수정
    public void modifyProductlowerCategory(ReqModifyLowerProductCategoryDto dto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerAdminId = principalUser.getId();
        ProductLowerCategory productLowerCategory = ProductLowerCategory.builder()
                .productLowerCategoryId(dto.getProductLowerCategoryId())
                .productLowerCategoryName(dto.getProductLowerCategoryName())
                .productLowerCategoryRegisterId(registerAdminId)
                .build();

        productManageMapper.modifyProductLowerCategory(productLowerCategory);
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
