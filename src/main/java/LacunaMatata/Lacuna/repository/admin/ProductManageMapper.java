package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.dto.request.admin.product.ReqModifyLowerProductCategoryDto;
import LacunaMatata.Lacuna.dto.request.admin.product.ReqModifyUpperProductDto;
import LacunaMatata.Lacuna.dto.response.admin.product.RespLowerProductCategoryDto;
import LacunaMatata.Lacuna.dto.response.admin.product.RespProductDetailDto;
import LacunaMatata.Lacuna.dto.response.admin.product.RespProductDto;
import LacunaMatata.Lacuna.dto.response.admin.product.RespUpperProductCategoryDto;
import LacunaMatata.Lacuna.entity.product.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductManageMapper {

    /** 상품 상위 분류 관련 Mapper */
    // 1. 상품 상위 분류 조회_2024.10.27
    List<ProductUpperCategory> getProductUpperCategoryList();
    // 2. 상품 상위 분류 등록_2024.10.27
    int saveProductUpperCategory(ProductUpperCategory productUpperCategory);
    // 3. 상품 상위 분류 단일 삭제_2024.10.27
    int deleteUpperProductCategory(int upperId);
    // 4. 상품 상위 분류 복수 삭제_2024.10.27
    int deleteUpperProductCategoryList(List<Integer> upperIdList);
    // 5. 상품 상위 분류 모달 조회_2024.10.27
    RespUpperProductCategoryDto getproductUpperDto(int upperId);
    // 6. 상품 상위 분류 모달 수정_2024.10.27
    int modifyProductUpperCategory(ProductUpperCategory productUpperCategory);

    List<ProductLowerCategory> getProductLowerCategoryList(int upperId); // 상품 상위분류에 해당하는 하위분류 카테고리 출력
    int saveProductLowerCategory(ProductLowerCategory productLowerCategory); // 상품 하위분류 등록
    RespLowerProductCategoryDto getProductLowerDto(int lowerId);
    int modifyProductLowerCategory(ProductLowerCategory productLowerCategory); // 상품 하위분류 수정
    int deleteProductLowerCategory(int lowerId); // 상품 하위분류 삭제
    int deleteProductLowerCategoryList(List<Integer> lowerIdList);

    List<RespProductDto> getProductList(Map<String,Object> params);
    int saveProduct(Product product);
    int saveConsultingContent(ConsultingContent consultingContent);
    int saveConsultingDetail(ConsultingDetail consultingDetail);
    int saveCosmeticDetail(CosmeticDetail cosmeticDetail);
    Product getProduct(int productId);
    ConsultingDetail getConsultingDetail(int productId);
    CosmeticDetail getCosmeticDetail(int productId);
    int modifyProduct(Product product);
    int modifyConsultingDetail(ConsultingDetail consultingDetail);
    int modifyConsultingContent(ConsultingContent consultingContent);
    int modifyCosmeticDetail(CosmeticDetail cosmeticDetail);
    int deleteProduct(int productId); // 상품 삭제
    int deleteProductList(List<Integer> productIdList);

    ProductUpperCategory findByNameProductUpperCategory(String upperCategoryName);
    ProductLowerCategory findByNameProductLowerCategory(String lowerCategoryName);
    ConsultingDetail findByIdConsultingDetail(int productId);
}
