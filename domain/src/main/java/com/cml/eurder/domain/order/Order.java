package com.cml.eurder.domain.order;

import com.cml.eurder.domain.item.Item;
import com.cml.eurder.domain.item.ItemRepository;
import com.cml.eurder.domain.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.cml.eurder.domain.order.OrderState.DELIVERED;
import static com.cml.eurder.domain.order.OrderState.IN_PROGRESS;

public class Order {
    private final String ID;
    private Customer customer;
    private List<Item> items;
    private double totalPrice;
    private OrderState orderState;

    public Order(Customer customer, List<Item> items) {
        this.items = new ArrayList<>();
        this.items = new ArrayList<>(items);
        this.ID = UUID.randomUUID().toString();
        this.customer = customer;
        this.totalPrice = calculateTotalPrice();
        this.orderState = IN_PROGRESS;
    }

    public double calculateTotalPrice(){
        return items.stream()
                .mapToDouble(item -> item.getPrice().getPriceAmount()*item.getItemAmount())
                .sum();
    }

    public void addItemToOrder(Item item, int amount){
        item.setItemAmount(amount);
        item.deductFromStockAmount(amount);
        items.add(item);
    }


    public void setOrderAsDelivered(){
        orderState = DELIVERED;
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
