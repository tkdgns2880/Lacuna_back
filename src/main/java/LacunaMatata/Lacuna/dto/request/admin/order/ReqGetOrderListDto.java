package LacunaMatata.Lacuna.dto.request.admin.order;

import lombok.Data;

@Data
public class ReqGetOrderListDto {
    private int filter;
    private int option;
    private String searchValue;
    private int page;
    private int limit;
}
