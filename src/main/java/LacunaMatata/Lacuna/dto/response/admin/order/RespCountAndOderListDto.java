package LacunaMatata.Lacuna.dto.response.admin.order;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespCountAndOderListDto {
    private int totalCount;
    private List<RespGetOrderListDto> orderList;
}
