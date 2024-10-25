package LacunaMatata.Lacuna.dto.request.admin.product;

import lombok.Data;

@Data
public class ReqGetProductListDto {
    private String productName;
    private String option;
    private String code;
    private int page;
    private int limit;
}
