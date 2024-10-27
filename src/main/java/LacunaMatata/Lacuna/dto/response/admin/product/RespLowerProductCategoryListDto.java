package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class RespLowerProductCategoryListDto {
    private int productLowerCategoryId;
    private String productLowerCategoryName;
    private String name;
    private LocalDateTime createdDate;
}
