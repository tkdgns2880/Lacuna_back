package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.dto.request.admin.product.ReqModifyLowerProductCategoryDto;
import LacunaMatata.Lacuna.dto.request.admin.product.ReqModifyUpperProductDto;
import LacunaMatata.Lacuna.entity.product.ProductLowerCategory;
import LacunaMatata.Lacuna.entity.product.ProductUpperCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductManageMapper {

    List<ProductUpperCategory> getProductUpperCategoryList(Map<String,Object> params); // 상품 상위분류 카테고리 출력
    int saveProductUpperCategory(ProductUpperCategory productUpperCategory); // 상품 상위분류 등록
    int modifyProductUpperCategory(ProductUpperCategory productUpperCategory); // 상품 상위분류 수정
    int deleteUpperProductCategory(int upperId); //상품 상위분류 삭제
    int deleteUpperProductCategoryList(List<Integer> upperIdList); // 상품 상위분류 복수개 삭제

    List<ProductLowerCategory> getProductLowerCategoryList(Map<String,Object> params); // 상품 상위분류에 해당하는 하위분류 카테고리 출력
    int saveProductLowerCategory(ProductLowerCategory productLowerCategory); // 상품 하위분류 등록
    int modifyProductLowerCategory(ProductLowerCategory productLowerCategory); // 상품 하위분류 수정
    int deleteProductLowerCategory(int lowerId); // 상품 하위분류 삭제
    int deleteProductLowerCategoryList(List<Integer> lowerIdList);

    int deleteProduct(int productId); // 상품 삭제
}
