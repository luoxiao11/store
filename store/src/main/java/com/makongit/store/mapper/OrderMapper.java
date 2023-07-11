package com.makongit.store.mapper;

import com.makongit.store.domain.Order;
import com.makongit.store.domain.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/** 处理订单及订单商品数据的持久层接口 */
@Mapper
public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单商品数据
     * @param orderItem 订单商品数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);
}
