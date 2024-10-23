package LacunaMatata.Lacuna.dto.request.admin.product;

import LacunaMatata.Lacuna.entity.product.Product;
import LacunaMatata.Lacuna.entity.product.ProductUpperCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqRegisterUpperProductCategoryDto {
//    @ApiModelProperty(value="데스트 데이터", example = "컨설팅", required = true)
    private String productUpperCategoryName;

    public ProductUpperCategory toProductUpperCategory() {
        return ProductUpperCategory.builder()
                .productUpperCategoryName(productUpperCategoryName)
                .build();
    }
}
