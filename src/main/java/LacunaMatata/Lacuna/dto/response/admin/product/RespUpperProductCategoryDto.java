package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class RespUpperProductCategoryDto {
    private int productUpperCategoryId;
    private String productUpperCategoryName;
    private String name;
    private LocalDateTime createdDate;
}
