package LacunaMatata.Lacuna.dto.response.admin.product;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespCountAndProductDto {
    private int totalCount;
    private List<RespProductDto> respProductDtoList;
}
