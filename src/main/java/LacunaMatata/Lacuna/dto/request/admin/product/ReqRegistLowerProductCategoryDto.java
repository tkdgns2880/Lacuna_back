package LacunaMatata.Lacuna.dto.request.admin.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReqRegistLowerProductCategoryDto {
    @ApiModelProperty(value="데스트", example = "Test", required = true)
    private String productLowerCategoryName;
}
