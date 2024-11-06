package LacunaMatata.Lacuna.dto.response.user.purchase.consultingProductList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespProductUpperCategoryDto {
    private int productUpperCategoryId;
    private String productUpperCategoryName;

    private List<RespProductLowerCategoryDto> productLowerCategory;
}
