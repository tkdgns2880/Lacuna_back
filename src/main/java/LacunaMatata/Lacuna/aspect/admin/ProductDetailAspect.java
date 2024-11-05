package LacunaMatata.Lacuna.aspect.admin;

import LacunaMatata.Lacuna.dto.response.admin.product.*;
import LacunaMatata.Lacuna.entity.product.ConsultingContent;
import LacunaMatata.Lacuna.entity.product.ConsultingDetail;
import LacunaMatata.Lacuna.entity.product.CosmeticDetail;
import LacunaMatata.Lacuna.entity.product.Product;
import LacunaMatata.Lacuna.repository.admin.ProductManageMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class ProductDetailAspect {

    @Autowired
    private ProductManageMapper productManageMapper;

    @Pointcut("@annotation(LacunaMatata.Lacuna.aspect.annotation.admin.ProductDetailAop)")
    public void pointCut() {}

    @Around("pointCut()")
    public Object after(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // ResponseEntity를 반환하고 그 내부의 Body를 캐스팅
        ResponseEntity<?> responseEntity = (ResponseEntity<?>) proceedingJoinPoint.proceed();
        Object body = responseEntity.getBody();

        int productId = (int) proceedingJoinPoint.getArgs()[0];

        List<RespUpperProductCategoryAndLowerDto> productUpperAndLower = productManageMapper.getProductUpperAndLowerCategoryList();
        List<ConsultingContent> consultingContent = productManageMapper.getConsultingContent();
        RespProductRegistModalDto respProductRegistModalDto = RespProductRegistModalDto.builder()
                .upperProductCategoryAndLower(productUpperAndLower)
                .productConsultingContentList(consultingContent)
                .build();

        if (body instanceof RespProductDetailDto) {

            Product product = productManageMapper.getProduct(productId);
            // 만약 컨설팅 관련 상품이면 컨설팅 내용만 담아서 보냄
            if(product.getProductUpperCategory().getProductUpperCategoryId() == 1) {
                List<ConsultingDetail> consultingDetail = productManageMapper.getConsultingDetail(productId);
                RespConsultingDetailDto respConsultingDetailDto = RespConsultingDetailDto.builder()
                        .productId(product.getProductId())
                        .productUpperCategoryId(product.getProductUpperCategory().getProductUpperCategoryId())
                        .productUpperCategoryName(product.getProductUpperCategory().getProductUpperCategoryName())
                        .productLowerCategoryId(product.getProductLowerCategory().getProductLowerCategoryId())
                        .productLowerCategoryName(product.getProductLowerCategory().getProductLowerCategoryName())
                        .productCode(product.getProductCode())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .promotionPrice(product.getPromotionPrice())
                        .productImg(product.getProductImg())
                        .description(product.getDescription())
                        .etc(product.getEtc())
                        .consultingDetail(consultingDetail)
                        .build();
                RespModifyConsultingProductModalDto modifyConsultingProduct = RespModifyConsultingProductModalDto.builder()
                        .productRegistModal(respProductRegistModalDto)
                        .consultingDetail(respConsultingDetailDto)
                        .build();
                return ResponseEntity.ok().body(modifyConsultingProduct);
            }

            // 만약 화장품 관련 상품이면 화장품 내용만 담아서 보냄
            if(product.getProductUpperCategory().getProductUpperCategoryId() == 2) {
                CosmeticDetail cosmeticDetail = productManageMapper.getCosmeticDetail(productId);
                RespCosmeticDetailDto respCosmeticDetailDto = RespCosmeticDetailDto.builder()
                        .productId(product.getProductId())
                        .productUpperCategoryId(product.getProductUpperCategory().getProductUpperCategoryId())
                        .productUpperCategoryName(product.getProductUpperCategory().getProductUpperCategoryName())
                        .productLowerCategoryId(product.getProductLowerCategory().getProductLowerCategoryId())
                        .productLowerCategoryName(product.getProductLowerCategory().getProductLowerCategoryName())
                        .productCode(product.getProductCode())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .promotionPrice(product.getPromotionPrice())
                        .productImg(product.getProductImg())
                        .description(product.getDescription())
                        .etc(product.getEtc())
                        .volume(cosmeticDetail.getVolume())
                        .ingredient(cosmeticDetail.getIngredient())
                        .skinType(cosmeticDetail.getSkinType())
                        .effect(cosmeticDetail.getEffect())
                        .manufacture(cosmeticDetail.getManufacture())
                        .productUrl(cosmeticDetail.getProductUrl())
                        .build();
                RespModifyCosmeticProductDto modifyCosmeticProduct = RespModifyCosmeticProductDto.builder()
                        .productRegistModal(respProductRegistModalDto)
                        .cosmeticDetail(respCosmeticDetailDto)
                        .build();
                return ResponseEntity.ok().body(modifyCosmeticProduct);
            }
        }

        // Body가 예상한 타입이 아닐 경우 원래의 ResponseEntity 반환
        return responseEntity;
    }
}
