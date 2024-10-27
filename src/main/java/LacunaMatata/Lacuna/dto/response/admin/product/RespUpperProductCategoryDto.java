package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespUpperProductCategoryDto {
    private int productUpperCategoryId;
    private String productUpperCategoryName;
}
