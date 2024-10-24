package LacunaMatata.Lacuna.dto.request.admin.product;

import LacunaMatata.Lacuna.entity.product.ProductLowerCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqRegisterLowerProductCategoryDto {
    @ApiModelProperty(value="데스트", example = "Test", required = true)
    private String productLowerCategoryName;
}
