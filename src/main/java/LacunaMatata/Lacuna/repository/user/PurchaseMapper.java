package LacunaMatata.Lacuna.repository.user;

import LacunaMatata.Lacuna.dto.response.user.purchase.RespProductUpperCategoryDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseMapper {
    RespProductUpperCategoryDto getConsultingProductList();
}
