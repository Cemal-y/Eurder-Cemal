package com.cml.eurder.service.order;

import com.cml.eurder.domain.item.Item;
import com.cml.eurder.domain.order.OrderState;
import com.cml.eurder.domain.user.Customer;
import java.util.concurrent.ConcurrentHashMap;


public class CreateOrderDto {
    private java.lang.String ID;
    private Customer customer;
    private ConcurrentHashMap<Item, Integer> items;
    private double totalPrice;
    private OrderState orderState;

    public CreateOrderDto() {
    }

    public CreateOrderDto(Customer customer, ConcurrentHashMap<Item, Integer> items, double totalPrice, OrderState orderState) {
        this.customer = customer;
        this.items = items;
        this.totalPrice = totalPrice;
        this.orderState = orderState;
    }

    public java.lang.String getID() {
        return ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ConcurrentHashMap<Item, Integer> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderState getOrderState() {
        return orderState;
    }
}
