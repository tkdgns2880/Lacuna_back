package LacunaMatata.Lacuna.service.user;

import LacunaMatata.Lacuna.dto.response.user.purchase.RespProductUpperCategoryDto;
import LacunaMatata.Lacuna.repository.user.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    // 회원 컨설팅 상품 목록 출력
    public RespProductUpperCategoryDto getConsultingProductList() {
        RespProductUpperCategoryDto productUpperCategory = purchaseMapper.getConsultingProductList();
        return productUpperCategory;
    }
}
