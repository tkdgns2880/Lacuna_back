package LacunaMatata.Lacuna.dto.request.admin.order;

import lombok.Data;

@Data
public class ReqGetOrderDto {
    private String option;
    private String search;
    private int page;
    private int limit;
}
