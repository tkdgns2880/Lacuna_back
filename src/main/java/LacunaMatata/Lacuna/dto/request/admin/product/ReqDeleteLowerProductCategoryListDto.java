package LacunaMatata.Lacuna.dto.request.admin.product;

import lombok.Data;

import java.util.List;

@Data
public class ReqDeleteLowerProductCategoryListDto {
    private List<Integer> lowerCategoryIdList;
}
