package LacunaMatata.Lacuna.entity.product;

import LacunaMatata.Lacuna.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductLowerCategory {
    private int productLowerCategoryId;
    private int productUpperCategoryId;
    private String productLowerCategoryName;
    private int productLowerCategoryRegisterId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    // 서브쿼리 계산용
    private int totalCount;

    private String productUpperCategoryName;

    private ProductUpperCategory productUpperCategory;
    private User user;
}
