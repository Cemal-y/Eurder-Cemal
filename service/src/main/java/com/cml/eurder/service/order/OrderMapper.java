package com.cml.eurder.service.order;

import com.cml.eurder.domain.item.Item;
import com.cml.eurder.domain.order.Order;
import com.cml.eurder.service.item.ItemDto;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.cml.eurder.domain.item.Item.ItemBuilder.itemBuilder;

@Component
public class OrderMapper {
    public Collection<OrderDto> toDto(Collection<Order> orderCollection) {
        return orderCollection.stream().map(this::toDto).collect(Collectors.toList());
    }

    public OrderDto toDto(Order order) {
        return new OrderDto(order.getID(), order.getCustomer(), order.getItems(), order.getTotalPrice(), order.getOrderState());
    }

    public Order toOrder(OrderDto orderDto) {
        return new Order(orderDto.getCustomer(), orderDto.getItems());
    }
}
