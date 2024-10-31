package LacunaMatata.Lacuna.aspect.admin;

import LacunaMatata.Lacuna.dto.response.admin.product.RespConsultingDetailDto;
import LacunaMatata.Lacuna.dto.response.admin.product.RespCosmeticDetailDto;
import LacunaMatata.Lacuna.dto.response.admin.product.RespProductDetailDto;
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

        if (body instanceof RespProductDetailDto) {

            Product product = productManageMapper.getProduct(productId);
            System.out.println(productId);
            System.out.println(product);
            // 만약 컨설팅 관련 상품이면 컨설팅 내용만 담아서 보냄
            if(product.getProductUpperCategory().getProductUpperCategoryId() == 1) {
                ConsultingDetail consultingDetail = productManageMapper.getConsultingDetail(productId);
                RespConsultingDetailDto respConsultingDetailDto = RespConsultingDetailDto.builder()
                        .productId(product.getProductId())
                        .productUpperCategoryId(product.getProductUpperCategory().getProductUpperCategoryId())
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
                System.out.println(consultingDetail);
                return ResponseEntity.ok().body(respConsultingDetailDto);
            }

            // 만약 화장품 관련 상품이면 화장품 내용만 담아서 보냄
            if(product.getProductUpperCategory().getProductUpperCategoryId() == 2) {
                CosmeticDetail cosmeticDetail = productManageMapper.getCosmeticDetail(productId);
                RespCosmeticDetailDto respCosmeticDetailDto = RespCosmeticDetailDto.builder()
                        .productId(product.getProductId())
                        .productUpperCategoryId(product.getProductUpperCategory().getProductUpperCategoryId())
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
                return ResponseEntity.ok().body(respCosmeticDetailDto);
            }
        }

        // Body가 예상한 타입이 아닐 경우 원래의 ResponseEntity 반환
        return responseEntity;
    }
}
