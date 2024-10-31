package LacunaMatata.Lacuna.service.admin;

import LacunaMatata.Lacuna.dto.request.admin.product.*;
import LacunaMatata.Lacuna.dto.response.admin.product.*;
import LacunaMatata.Lacuna.entity.product.*;
import LacunaMatata.Lacuna.repository.admin.ProductManageMapper;
import LacunaMatata.Lacuna.security.principal.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductManageService {

    @Autowired
    private ProductManageMapper productManageMapper;

    // 상품 상위 분류 리스트 출력
    public RespCountAndUpperProductDto getProductUpperCategory() {
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
        int totalCount = productUpperCategoryList.isEmpty() ? 0 : productUpperCategoryList.get(0).getTotalCount();
        RespCountAndUpperProductDto respCountAndUpperProductDto = RespCountAndUpperProductDto.builder()
                .totalCount(totalCount)
                .productUpperCategoryList(productUpperCategory)
                .build();

        return respCountAndUpperProductDto;
    }

    // 상품 상위 분류 카테고리 등록
    public void registProductUpperCategory(ReqRegistUpperProductCategoryDto dto) {

        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerId = principalUser.getId();
        ProductUpperCategory productUpperCategory = ProductUpperCategory.builder()
                .productUpperCategoryName(dto.getProductUpperCategoryName())
                .productUpperCategoryRegisterId(registerId)
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
        int registerId = principalUser.getId();
        ProductUpperCategory productUpperCategory = ProductUpperCategory.builder()
                .productUpperCategoryId(dto.getProductUpperCategoryId())
                .productUpperCategoryName(dto.getProductUpperCategoryName())
                .productUpperCategoryRegisterId(registerId)
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
    public RespCountAndLowerProductDto getProductlowerCategory(int upperId) {
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
        int totalCount = productLowerCategoryList.isEmpty() ? 0 : productLowerCategoryList.get(0).getTotalCount();

        RespCountAndLowerProductDto respCountAndLowerProductDto = RespCountAndLowerProductDto.builder()
                .totalCount(totalCount)
                .productLowerCategoryList(productLowerCategory)
                .build();

        return respCountAndLowerProductDto;
    }

    // 상품 하위 분류 카테고리 등록
    public void registProductlowerCategory(ReqRegistLowerProductCategoryDto dto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int registerId = principalUser.getId();
        ProductLowerCategory productLowerCategory = ProductLowerCategory.builder()
                .productLowerCategoryName(dto.getProductLowerCategoryName())
                .productLowerCategoryRegisterId(registerId)
                .productUpperCategoryId(dto.getProductUpperCategoryId())
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
        int registerId = principalUser.getId();
        ProductLowerCategory productLowerCategory = ProductLowerCategory.builder()
                .productLowerCategoryId(dto.getProductLowerCategoryId())
                .productLowerCategoryName(dto.getProductLowerCategoryName())
                .productLowerCategoryRegisterId(registerId)
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
    public RespCountAndProductDto getProducts(ReqGetProductListDto dto) {
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
        int totalCount = productList.isEmpty() ? 0 : productList.get(0).getTotalCount();

        RespCountAndProductDto respCountAndProductDto = RespCountAndProductDto.builder()
                .totalCount(totalCount)
                .respProductDtoList(respProductDtoList)
                .build();

        return respCountAndProductDto;
    }

    // 상품 등록
    @Transactional(rollbackFor = Exception.class)
    public void registProduct(ReqRegistProductDto dto) {
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
        RespProductDetailDto productConsultingDetail = RespProductDetailDto.builder()
                .productId(product.getProductId())
                .productUpperCategoryId(product.getProductUpperCategory().getProductUpperCategoryId())
                .productUpperCategoryName(product.getProductUpperCategory().getProductUpperCategoryName())
                .productLowerCategoryName(product.getProductLowerCategory().getProductLowerCategoryName())
                .productCode(product.getProductCode())
                .productName(product.getProductName())
                .price(product.getPrice())
                .promotionPrice(product.getPromotionPrice())
                .productImg(product.getProductImg())
                .build();
        return productConsultingDetail;
    }

    // 상품 수정
    @Transactional(rollbackFor = Exception.class)
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

    // 상품 상위 카테고리 분류 출력(필터용)
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

    // 상품 하위 카테고리 분류 출력(필터용)
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
