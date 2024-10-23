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
public class ProductUpperCategory {
    private int productUpperCategoryId;
    private String productUpperCategoryName;
    private int productUpperCategoryRegisterId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private User user;
}
