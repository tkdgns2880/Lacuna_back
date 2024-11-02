package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespLowerCategoryAndProductDto {
    private int productLowerCategoryId;
    private String productLowerCategoryName;
}
