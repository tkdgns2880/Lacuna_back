package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.dto.request.admin.product.ReqModifyLowerProductCategoryDto;
import LacunaMatata.Lacuna.dto.request.admin.product.ReqModifyUpperProductDto;
import LacunaMatata.Lacuna.entity.product.ProductUpperCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductManageMapper {

    int saveProductUpperCategory(String productUpperCategoryName); // 상품 상위분류 등록
    int modifyProductUpperCategory(ReqModifyUpperProductDto dto); // 상품 상위분류 수정
    int deleteUpperProductCategory(int upperId); //상품 상위분류 삭제
    int saveProductLowerCategory(String productLowerCategoryName); // 상품 하위분류 등록
    int modifyProductLowerCategory(ReqModifyLowerProductCategoryDto dto); // 상품 하위분류 수정
    int deleteProductLowerCategory(int lowerId); // 상품 하위분류 삭제
    int deleteProduct(int productId); // 상품 삭제
}
