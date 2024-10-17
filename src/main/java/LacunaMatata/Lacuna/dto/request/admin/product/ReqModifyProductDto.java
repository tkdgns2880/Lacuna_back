package LacunaMatata.Lacuna.dto.request.admin.product;

import lombok.Data;

@Data
public class ReqModifyProductDto {
    private int productId;
    private String productUpperCategoryName;
    private String productLowerCategoryName;
    private String productCode;
    private String productName;
    private String productDescription;
    private int price;
    private int promotionPrice;
    private String productImg;
    private String detailName;
    private String detailDescription;
    private int detailOptionPrice;
}
