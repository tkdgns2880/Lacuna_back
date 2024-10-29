package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespLowerProductCategoryDto {
    private int productLowerCategoryId;
    private String productLowerCategoryName;
}
