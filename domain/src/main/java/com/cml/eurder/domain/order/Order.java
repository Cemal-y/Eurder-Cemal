package com.cml.eurder.domain.order;

import com.cml.eurder.domain.item.Item;
import com.cml.eurder.domain.item.ItemRepository;
import com.cml.eurder.domain.user.Customer;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static com.cml.eurder.domain.order.OrderState.DELIVERED;
import static com.cml.eurder.domain.order.OrderState.IN_PROGRESS;

public class Order {
    private final String ID;
    private String customerId;
//    private ConcurrentHashMap<String, Integer> itemsWithAmount;
    List<OrderItem> itemsWithAmount;
    private double totalPrice;
    private OrderState orderState;

    public Order(String customerId, List<OrderItem> itemsToAdd) {
        this.ID = UUID.randomUUID().toString();
        this.itemsWithAmount = itemsToAdd;
        this.customerId = customerId;
        this.totalPrice = calculateTotalPrice();
        this.orderState = IN_PROGRESS;
    }

    public double calculateTotalPrice(){
        return itemsWithAmount.stream()
                .mapToDouble(item -> item.getItem().getPrice().getPriceAmount()
                        * item.getItemAmount())
                .sum();
    }

//    public double calculateTotalPrice(){
//        return itemsWithAmount.keySet().stream()
//                .mapToDouble(itemId -> itemRepository.getItemById(itemId).getPrice().getPriceAmount()
//                        * itemsWithAmount.get(itemId))
//                .sum();
//    }

//    public void addItemToOrder(Item item, int amount){
//        item.setItemAmount(amount);
//        item.deductFromStockAmount(amount);
//        items.add(item);
//    }


    public void setOrderAsDelivered(){
        orderState = DELIVERED;
    }

    public java.lang.String getID() {
        return ID;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getItemsWithAmount() {
        return itemsWithAmount;
    }

    //    public ConcurrentHashMap<String, Integer> getItemsWithAmount() {
//        return itemsWithAmount;
//    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderState getOrderState() {
        return orderState;
    }
}
