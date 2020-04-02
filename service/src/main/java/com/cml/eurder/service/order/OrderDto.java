package com.cml.eurder.service.order;

import com.cml.eurder.domain.item.Item;
import com.cml.eurder.domain.order.OrderState;
import com.cml.eurder.domain.user.Customer;

import java.util.List;

public class OrderDto {
    private String ID;
    private Customer customer;
    private List<Item> items;
    private double totalPrice;
    private OrderState orderState;

    public OrderDto() {
    }
    public OrderDto(String ID, Customer customer, List<Item> items, double totalPrice, OrderState orderState) {
        this.ID = ID;
        this.customer = customer;
        this.items = items;
        this.totalPrice = totalPrice;
        this.orderState = orderState;
    }

    public String getID() {
        return ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderState getOrderState() {
        return orderState;
    }
}
