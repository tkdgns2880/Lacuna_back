package LacunaMatata.Lacuna.dto.request.admin.product;

import lombok.Data;

@Data
public class ReqGetProductListDto {
    private int filter;
    private int option;
    private String searchValue;
    private int page;
    private int limit;
}
