package LacunaMatata.Lacuna.dto.response.user.purchase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespProductLowerCategoryDto {
    private int productLowerCategoryId;
    private String productLowerCategoryName;

    private List<RespConsultingProductDto> consultingProduct;
}
