package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.product.*;
import LacunaMatata.Lacuna.dto.response.admin.product.RespLowerProductCategoryDto;
import LacunaMatata.Lacuna.dto.response.admin.product.RespProductDto;
import LacunaMatata.Lacuna.dto.response.admin.product.RespUpperProductCategoryDto;
import LacunaMatata.Lacuna.entity.product.*;
import LacunaMatata.Lacuna.repository.admin.ProductManageMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
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
    public void deleteProductUpperCategoryList(ReqDeleteUpperProductCategoryListDto dto) {
        List<Integer> upperIdList = dto.getUpperCategoryIdList();
        productManageMapper.deleteUpperProductCategoryList(upperIdList);
    }

    // 상품 하위 분류 리스트 출력
    public List<RespLowerProductCategoryDto> getProductlowerCategory(ReqGetLowerProductCategoryListDto dto, int upperId) {
        int startIndex = (dto.getPage() - 1) * dto.getLimit();
        Map<String, Object> params = Map.of(
                "startIndex", startIndex,
                "limit", dto.getLimit(),
                "upperId", upperId
        );
        List<ProductLowerCategory> productLowerCategoryList = productManageMapper.getProductLowerCategoryList(params);
        List<RespLowerProductCategoryDto> productLowerCategory = new ArrayList<>();
        for(ProductLowerCategory productLowerCategoryDto : productLowerCategoryList) {
            RespLowerProductCategoryDto respLowerProductCategoryDto = RespLowerProductCategoryDto.builder()
                    .productLowerCategoryId(productLowerCategoryDto.getProductLowerCategoryId())
                    .productLowerCategoryName(productLowerCategoryDto.getProductLowerCategoryName())
                    .name(productLowerCategoryDto.getUser().getName())
                    .createdDate(productLowerCategoryDto.getCreateDate())
                    .build();
            productLowerCategory.add(respLowerProductCategoryDto);
        }

        return productLowerCategory;
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
    public void deleteProductlowerCategoryList(ReqDeleteLowerProductCategoryListDto dto) {
        List<Integer> lowerIdList = dto.getLowerCategoryIdList();
        productManageMapper.deleteUpperProductCategoryList(lowerIdList);
    }

    // 상품 리스트 출력
    public List<RespProductDto> getProducts(ReqGetProductListDto dto) {
        int startIndex = (dto.getPage() - 1) * dto.getLimit();
        Map<String, Object> params = Map.of(
                "option", dto.getOption(),
                "productName", dto.getProductName(),
                "code", dto.getCode(),
                "startIndex", startIndex,
                "limit", dto.getLimit()
        );
        System.out.println(params);
        List<RespProductDto> productList = productManageMapper.getProductList(params);
        System.out.println(productList);

        return productList;
    }

    // 상품 등록
    public void registerProduct(ReqRegisterProductDto dto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerId = principalUser.getId();
        ProductUpperCategory productUpperCategory
                = productManageMapper.findByNameProductUpperCategory(dto.getProductUpperCategoryName());
        ProductLowerCategory productLowerCategory
                = productManageMapper.findByNameProductLowerCategory(dto.getProductLowerCategoryName());

        Product product = Product.builder()
                .productLowerCategoryId(productLowerCategory.getProductLowerCategoryId())
                .productCode(dto.getProductCode())
                .productName(dto.getProductName())
                .price(BigDecimal.valueOf(dto.getPrice()))
                .promotionPrice(BigDecimal.valueOf(dto.getPromotionPrice()))
                .productImg(dto.getProductImg())
                .productRegisterId(registerId)
                .build();
        int productId = productManageMapper.saveProduct(product);

        switch (productUpperCategory.getProductUpperCategoryId()) {
            case 1:
                ConsultingContent consultingContent = ConsultingContent.builder()
                        .name(dto.getConsultingName())
                        .build();
                int consultingContentId = productManageMapper.saveConsultingContent(consultingContent);

                ConsultingDetail consultingDetail = ConsultingDetail.builder()
                        .consultingDetailProductId(productId)
                        .consultingDetailContentId(consultingContentId)
                        .repeatCount(dto.getRepeatCount())
                        .description(dto.getConsultingDescription())
                        .etc(dto.getEtc())
                        .build();
                productManageMapper.saveConsultingDetail(consultingDetail);
                break;
            case 2:
                CosmeticDetail cosmeticDetail = CosmeticDetail.builder()
                        .cosmeticDetailProductId(productId)
                        .volume(dto.getVolume())
                        .ingredient(dto.getIngredient())
                        .skinType(dto.getSkinType())
                        .effect(dto.getEffect())
                        .manufacture(dto.getManufacture())
                        .productDescription(dto.getCosmeticProductDescription())
                        .productUrl(dto.getProductUrl())
                        .etc(dto.getEtc())
                        .build();
                productManageMapper.saveCosmeticDetail(cosmeticDetail);
                break;
        }
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
