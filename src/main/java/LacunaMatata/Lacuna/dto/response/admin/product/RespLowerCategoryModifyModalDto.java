package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespLowerCategoryModifyModalDto {
    RespLowerProductCategoryDto productLowerCategory;
    List<RespUpperProductCategoryDto> productUpperCategoryList;
}
