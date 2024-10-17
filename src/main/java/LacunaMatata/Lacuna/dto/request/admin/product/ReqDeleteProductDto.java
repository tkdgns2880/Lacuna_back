package LacunaMatata.Lacuna.dto.request.admin.product;

import lombok.Data;

import java.util.List;

@Data
public class ReqDeleteProductDto {
    private List<Integer> productIdList;
}
