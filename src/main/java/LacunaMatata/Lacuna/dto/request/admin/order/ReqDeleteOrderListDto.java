package LacunaMatata.Lacuna.dto.request.admin.order;

import lombok.Data;

import java.util.List;

@Data
public class ReqDeleteOrderListDto {
    private List<Integer> orderIdList;
}
