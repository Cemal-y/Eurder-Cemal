package com.cml.eurder.service.order;

import com.cml.eurder.domain.item.ItemRepository;
import com.cml.eurder.domain.order.OrderRepository;
import com.cml.eurder.service.item.ItemDto;
import com.cml.eurder.service.item.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public Collection<OrderDto> getAllActiveOrders() {
        return orderMapper.toDto(orderRepository.getActiveOrders());
    }

    public Collection<OrderDto> getDeliveredOrders() {
        return orderMapper.toDto(orderRepository.getActiveOrders());
    }

    public OrderDto addOrder(OrderDto orderDto){
        return orderMapper.toDto(orderRepository.createOrder(orderMapper.toOrder(orderDto)));
    }

}
