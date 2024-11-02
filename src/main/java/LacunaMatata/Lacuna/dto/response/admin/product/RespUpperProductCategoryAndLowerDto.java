package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespUpperProductCategoryAndLowerDto {
    private int productUpperCategoryId;
    private String productUpperCategoryName;
    private List<RespLowerCategoryAndProductDto> productLowerCategoryAndProduct;
}
