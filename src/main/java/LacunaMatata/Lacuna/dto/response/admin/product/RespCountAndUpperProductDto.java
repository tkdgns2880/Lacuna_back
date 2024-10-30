package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespCountAndUpperProductDto {
    private int totalCount;
    private List<RespUpperProductCategoryListDto> productUpperCategoryList;
}
