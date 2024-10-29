package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.product.*;
import LacunaMatata.Lacuna.dto.response.admin.product.*;
import LacunaMatata.Lacuna.entity.product.*;
import LacunaMatata.Lacuna.repository.admin.ProductManageMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductManageService {

    @Autowired
    private ProductManageMapper productManageMapper;

    // 상품 상위 분류 리스트 출력
    public List<RespUpperProductCategoryListDto> getProductUpperCategory() {
        List<ProductUpperCategory> productUpperCategoryList = productManageMapper.getProductUpperCategoryList();
        List<RespUpperProductCategoryListDto> productUpperCategory = new ArrayList<RespUpperProductCategoryListDto>();
        for(ProductUpperCategory productUpperCategoryDto : productUpperCategoryList) {
            RespUpperProductCategoryListDto respUpperProductCategoryListDto = RespUpperProductCategoryListDto.builder()
                    .productUpperCategoryId(productUpperCategoryDto.getProductUpperCategoryId())
                    .productUpperCategoryName(productUpperCategoryDto.getProductUpperCategoryName())
                    .name(productUpperCategoryDto.getUser().getName())
                    .createdDate(productUpperCategoryDto.getCreateDate())
                    .build();
            productUpperCategory.add(respUpperProductCategoryListDto);
        }

        return productUpperCategory;
    }

    // 상품 상위 분류 카테고리 등록
    public void registeProductUpperCategory(ReqRegisteUpperProductCategoryDto dto) {

        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registeAdminId = principalUser.getId();
        ProductUpperCategory productUpperCategory = ProductUpperCategory.builder()
                .productUpperCategoryName(dto.getProductUpperCategoryName())
                .productUpperCategoryRegisterId(registeAdminId)
                .build();

        productManageMapper.saveProductUpperCategory(productUpperCategory);
    }

    // 상품 상위 분류 카테고리 항목 출력
    public RespUpperProductCategoryDto getProductUpper(int upperId) {
        ProductUpperCategory respUpperCategory = productManageMapper.getproductUpperDto(upperId);
        RespUpperProductCategoryDto upperCategory = RespUpperProductCategoryDto.builder()
                .productUpperCategoryId(respUpperCategory.getProductUpperCategoryId())
                .productUpperCategoryName(respUpperCategory.getProductUpperCategoryName())
                .build();
        return upperCategory;
    }

    // 상품 상위 분류 카테고리 수정
    public void modifyProductUpperCategory(ReqModifyUpperProductDto dto, int upperId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registeAdminId = principalUser.getId();
        ProductUpperCategory productUpperCategory = ProductUpperCategory.builder()
                .productUpperCategoryId(dto.getProductUpperCategoryId())
                .productUpperCategoryName(dto.getProductUpperCategoryName())
                .productUpperCategoryRegisterId(registeAdminId)
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
    public List<RespLowerProductCategoryListDto> getProductlowerCategory(int upperId) {
        List<ProductLowerCategory> productLowerCategoryList = productManageMapper.getProductLowerCategoryList(upperId);
        List<RespLowerProductCategoryListDto> productLowerCategory = new ArrayList<RespLowerProductCategoryListDto>();
        for(ProductLowerCategory productLowerCategoryDto : productLowerCategoryList) {
            RespLowerProductCategoryListDto respLowerProductCategoryListDto = RespLowerProductCategoryListDto.builder()
                    .productLowerCategoryId(productLowerCategoryDto.getProductLowerCategoryId())
                    .productLowerCategoryName(productLowerCategoryDto.getProductLowerCategoryName())
                    .name(productLowerCategoryDto.getUser().getName())
                    .createdDate(productLowerCategoryDto.getCreateDate())
                    .build();
            productLowerCategory.add(respLowerProductCategoryListDto);
        }

        return productLowerCategory;
    }

    // 상품 하위 분류 카테고리 등록
    public void registeProductlowerCategory(ReqRegisteLowerProductCategoryDto dto, int upperId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registeAdminId = principalUser.getId();
        ProductLowerCategory productLowerCategory = ProductLowerCategory.builder()
                .productLowerCategoryName(dto.getProductLowerCategoryName())
                .productLowerCategoryRegisterId(registeAdminId)
                .productUpperCategoryId(upperId)
                .build();

        productManageMapper.saveProductLowerCategory(productLowerCategory);
    }

    // 상품 하위 분류 카테고리 항목 출력
    public RespLowerProductCategoryDto getProductLower(int lowerId) {
        ProductLowerCategory respLowerCategory = productManageMapper.getProductLowerDto(lowerId);
        RespLowerProductCategoryDto lowerCategory = RespLowerProductCategoryDto.builder()
                .productLowerCategoryId(respLowerCategory.getProductLowerCategoryId())
                .productLowerCategoryName(respLowerCategory.getProductLowerCategoryName())
                .build();
        return lowerCategory;
    }

    // 상품 하위 분류 카테고리 수정
    public void modifyProductlowerCategory(ReqModifyLowerProductCategoryDto dto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registeAdminId = principalUser.getId();
        ProductLowerCategory productLowerCategory = ProductLowerCategory.builder()
                .productLowerCategoryId(dto.getProductLowerCategoryId())
                .productLowerCategoryName(dto.getProductLowerCategoryName())
                .productLowerCategoryRegisterId(registeAdminId)
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
                "filter", dto.getFilter(),
                "option", dto.getOption(),
                "searchValue", dto.getSearchValue(),
                "startIndex", startIndex,
                "limit", dto.getLimit()
        );
        List<Product> productList = productManageMapper.getProductList(params);
        List<RespProductDto> respProductDtoList = new ArrayList<RespProductDto>();
        for(Product product : productList) {
            RespProductDto respProductDto = RespProductDto.builder()
                    .productId(product.getProductId())
                    .productCode(product.getProductCode())
                    .productUpperCategoryName(product.getProductUpperCategory().getProductUpperCategoryName())
                    .productName(product.getProductName())
                    .price(product.getPrice())
                    .promotionPrice(product.getPromotionPrice())
                    .name(product.getUser().getName())
                    .createdDate(product.getCreateDate())
                    .build();
            respProductDtoList.add(respProductDto);
        }

//        System.out.println("resp 데이터 : " + respProductDtoList);
        return respProductDtoList;
    }

    // 상품 등록
    public void registeProduct(ReqRegisteProductDto dto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registeId = principalUser.getId();
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
                .productRegisterId(registeId)
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
        int registeId = principalUser.getId();
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
                .productRegisterId(registeId)
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

    public List<RespUpperProductCategoryDto> getUpperProductFilter() {
        List<ProductUpperCategory> upperFilter = productManageMapper.getProductUpperCategoryList();
        List<RespUpperProductCategoryDto> upperFilterList = new ArrayList<RespUpperProductCategoryDto>();
        for(ProductUpperCategory productUpperCategory : upperFilter) {
            RespUpperProductCategoryDto upperFilter2 = RespUpperProductCategoryDto.builder()
                    .productUpperCategoryId(productUpperCategory.getProductUpperCategoryId())
                    .productUpperCategoryName(productUpperCategory.getProductUpperCategoryName())
                    .build();
            upperFilterList.add(upperFilter2);
        }
        return upperFilterList;
    }

    public List<RespLowerProductCategoryDto> getLowerProductFilter(int upperId) {
        List<ProductLowerCategory> lowerFilter = productManageMapper.getProductLowerCategoryList(upperId);
        List<RespLowerProductCategoryDto> lowerFilterList = new ArrayList<RespLowerProductCategoryDto>();
        for(ProductLowerCategory productLowerCategory : lowerFilter) {
            RespLowerProductCategoryDto lowerFilter2 = RespLowerProductCategoryDto.builder()
                    .productLowerCategoryId(productLowerCategory.getProductLowerCategoryId())
                    .productLowerCategoryName(productLowerCategory.getProductLowerCategoryName())
                    .build();
            lowerFilterList.add(lowerFilter2);
        }
        return lowerFilterList;
    }
}
