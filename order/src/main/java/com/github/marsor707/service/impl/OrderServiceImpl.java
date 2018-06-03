package com.github.marsor707.service.impl;

import com.github.marsor707.dataobject.OrderMaster;
import com.github.marsor707.dto.OrderDTO;
import com.github.marsor707.enums.OrderStatusEnum;
import com.github.marsor707.enums.PayStatusEnum;
import com.github.marsor707.repository.OrderDetailRepository;
import com.github.marsor707.repository.OrderMasterRepository;
import com.github.marsor707.service.OrderService;
import com.github.marsor707.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //todo 查询商品信息（商品服务）
        //todo 计算总价
        //todo 扣库存（商品服务）

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
