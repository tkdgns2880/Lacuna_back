package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.product.*;
import LacunaMatata.Lacuna.dto.response.admin.product.RespLowerProductCategoryDto;
import LacunaMatata.Lacuna.dto.response.admin.product.RespProductDetailDto;
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

    // 상품 상위 분류 카테고리 항목 출력
    public RespUpperProductCategoryDto getProductUpper(int upperId) {
        RespUpperProductCategoryDto respUpperCategory = productManageMapper.getproductUpperDto(upperId);
        return respUpperCategory;
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

    // 상품 하위 분류 카테고리 항목 출력
    public RespLowerProductCategoryDto getProductLower(int lowerId) {
        RespLowerProductCategoryDto respLowerCategory = productManageMapper.getProductLowerDto(lowerId);
        return respLowerCategory;
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
        productManageMapper.deleteProductLowerCategoryList(lowerIdList);
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

    // 상품 항목 출력
    public RespProductDetailDto getProductDetail(int productId) {
        Product product = productManageMapper.getProduct(productId);
        RespProductDetailDto productDetail = null;
        // 만약 컨설팅 관련 상품이면 컨설팅 내용만 담아서 보냄
        if(product.getProductUpperCategory().getProductUpperCategoryId() == 1) {
            ConsultingDetail consultingDetail = productManageMapper.getConsultingDetail(productId);
            RespProductDetailDto productConsultingDetail = RespProductDetailDto.builder()
                    .productId(product.getProductId())
                    .productUpperCategoryName(product.getProductUpperCategory().getProductUpperCategoryName())
                    .productLowerCategoryName(product.getProductLowerCategory().getProductLowerCategoryName())
                    .productCode(product.getProductCode())
                    .productName(product.getProductName())
                    .price(product.getPrice())
                    .promotionPrice(product.getPromotionPrice())
                    .productImg(product.getProductImg())
                    .repeatCount(consultingDetail.getRepeatCount())
                    .consultingDescription(consultingDetail.getDescription())
                    .consultingName(consultingDetail.getConsultingContent().getName())
                    .etc(consultingDetail.getEtc())
                    .build();
            productDetail = productConsultingDetail;
        }

        // 만약 화장품 관련 상품이면 화장품 내용만 담아서 보냄
        if(product.getProductUpperCategory().getProductUpperCategoryId() == 2) {
            CosmeticDetail cosmeticDetail = productManageMapper.getCosmeticDetail(productId);
            RespProductDetailDto productCosmeticDetail = RespProductDetailDto.builder()
                    .productId(product.getProductId())
                    .productUpperCategoryName(product.getProductUpperCategory().getProductUpperCategoryName())
                    .productLowerCategoryName(product.getProductLowerCategory().getProductLowerCategoryName())
                    .productCode(product.getProductCode())
                    .productName(product.getProductName())
                    .price(product.getPrice())
                    .promotionPrice(product.getPromotionPrice())
                    .productImg(product.getProductImg())
                    .volume(cosmeticDetail.getVolume())
                    .ingredient(cosmeticDetail.getIngredient())
                    .skinType(cosmeticDetail.getSkinType())
                    .effect(cosmeticDetail.getEffect())
                    .manufacture(cosmeticDetail.getManufacture())
                    .cosmeticProductDescription(cosmeticDetail.getProductDescription())
                    .productUrl(cosmeticDetail.getProductUrl())
                    .etc(cosmeticDetail.getEtc())
                    .build();
            productDetail = productCosmeticDetail;
        }
        return productDetail;
    }

    // 상품 수정
    public void modifyProduct(ReqModifyProductDto dto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerId = principalUser.getId();
        ProductUpperCategory productUpperCategory
                = productManageMapper.findByNameProductUpperCategory(dto.getProductUpperCategoryName());
        ProductLowerCategory productLowerCategory
                = productManageMapper.findByNameProductLowerCategory(dto.getProductLowerCategoryName());

        Product product = Product.builder()
                .productId(dto.getProductId())
                .productCode(dto.getProductCode())
                .productName(dto.getProductName())
                .price(BigDecimal.valueOf(dto.getPrice()))
                .promotionPrice(BigDecimal.valueOf(dto.getPromotionPrice()))
                .productImg(dto.getProductImg())
                .productRegisterId(registerId)
                .build();

        if(productUpperCategory.getProductUpperCategoryId() == 1) {
            productManageMapper.modifyProduct(product);
            ConsultingDetail consultingDetail = ConsultingDetail.builder()
                    .consultingDetailProductId(dto.getProductId())
                    .repeatCount(dto.getRepeatCount())
                    .description(dto.getConsultingDescription())
                    .etc(dto.getEtc())
                    .build();
            productManageMapper.modifyConsultingDetail(consultingDetail);

            ConsultingDetail modifyConsultingDetail
                    = productManageMapper.findByIdConsultingDetail(dto.getProductId());

            ConsultingContent consultingContent = ConsultingContent.builder()
                    .consultingContentId(modifyConsultingDetail.getConsultingDetailContentId())
                    .name(dto.getConsultingName())
                    .build();
            productManageMapper.modifyConsultingContent(consultingContent);
        }

        if(productUpperCategory.getProductUpperCategoryId() == 2) {
            productManageMapper.modifyProduct(product);
            CosmeticDetail cosmeticDetail = CosmeticDetail.builder()
                    .cosmeticDetailProductId(dto.getProductId())
                    .volume(dto.getVolume())
                    .ingredient(dto.getIngredient())
                    .skinType(dto.getSkinType())
                    .effect(dto.getEffect())
                    .manufacture(dto.getManufacture())
                    .productDescription(dto.getCosmeticProductDescription())
                    .productUrl(dto.getProductUrl())
                    .etc(dto.getEtc())
                    .build();
            productManageMapper.modifyCosmeticDetail(cosmeticDetail);
        }
    }

    // 상품 삭제
    public void deleteProduct(int productId) {
        productManageMapper.deleteProduct(productId);
    }

    // 상품 복수개 삭제
    public void deleteProductList(ReqDeleteProductDto dto) {
        List<Integer> productIdList =  dto.getProductIdList();
        productManageMapper.deleteProductList(productIdList);
    }
}
