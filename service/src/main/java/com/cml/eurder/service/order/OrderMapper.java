package com.cml.eurder.service.order;

import com.cml.eurder.domain.order.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public Collection<OrderDto> toDto(Collection<Order> orderCollection) {
        return orderCollection.stream().map(this::toDto).collect(Collectors.toList());
    }

    public OrderDto toDto(Order order) {
        return new OrderDto(order.getID(), order.getCustomerId(), order.getItemsWithAmount()
                , order.getTotalPrice(), order.getOrderState());
    }

    public Order toOrder(OrderDto orderDto) {
        return new Order(orderDto.getCustomerId(), orderDto.getItems());
    }
}
