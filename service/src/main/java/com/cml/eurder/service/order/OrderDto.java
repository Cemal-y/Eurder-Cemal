package com.cml.eurder.service.order;

import com.cml.eurder.domain.item.Item;
import com.cml.eurder.domain.order.OrderItem;
import com.cml.eurder.domain.order.OrderState;
import com.cml.eurder.domain.user.Customer;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class OrderDto {
    private String ID;
    private String customerId;
    private List<OrderItem> items;
    private double totalPrice;
    private OrderState orderState;

    public OrderDto() {
    }
    public OrderDto(String ID, String customerId, List<OrderItem> items, double totalPrice, OrderState orderState) {
        this.ID = ID;
        this.customerId = customerId;
        this.items = items;
        this.totalPrice = totalPrice;
        this.orderState = orderState;
    }

    public String getID() {
        return ID;
    }

    public String getCustomerId() {
        return customerId;
    }

    //    public List<Item> getItems() {
//        return items;
//    }


    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderState getOrderState() {
        return orderState;
    }
}
