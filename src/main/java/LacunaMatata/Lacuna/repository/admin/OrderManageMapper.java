package LacunaMatata.Lacuna.repository.admin;

import LacunaMatata.Lacuna.entity.order.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderManageMapper {

    /** orderManage(회원 주문 관리) 관련 Mapper */
    // 1. 사용자 주문 출력_2024.10.30
    List<Order> getOrderList(Map<String, Object> params);
}
