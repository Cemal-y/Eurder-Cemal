package com.cml.eurder.domain.order;

import com.cml.eurder.domain.exceptions.InputCanNotBeNullException;
import com.cml.eurder.domain.item.Currency;
import com.cml.eurder.domain.item.Item;
import com.cml.eurder.domain.item.Price;
import com.cml.eurder.domain.user.Customer;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.cml.eurder.domain.item.Currency.EURO;
import static com.cml.eurder.domain.item.Item.ItemBuilder.itemBuilder;
import static com.cml.eurder.domain.order.OrderState.DELIVERED;
import static com.cml.eurder.domain.order.OrderState.IN_PROGRESS;
import static com.cml.eurder.domain.user.Customer.Builder.customerBuilder;

@Repository
public class OrderRepository {
    ConcurrentHashMap<String, Order> orderDatabase;

    public OrderRepository() {
        this.orderDatabase = new ConcurrentHashMap<>();
        createDefaultData();
    }

    public Order createOrder(Order order){
        checkIfInputNull(order);
        orderDatabase.put(order.getID(), order);
        return order;
    }


//    public Order createOrder(Customer customer, Item... items){
//        checkIfInputNull(items);
//        checkIfInputNull(customer);
//        Order order = new Order(customer, Arrays.asList(items));
//        orderDatabase.put(order.getID(), order);
//        return order;
//    }

    public Collection<Order> getActiveOrders(){
        return orderDatabase.values().stream()
                .filter(order -> order.getOrderState().equals(IN_PROGRESS))
                .collect(Collectors.toList());
    }

    public Collection<Order> getDeliveredOrders(){
        return orderDatabase.values().stream()
                .filter(order -> order.getOrderState().equals(DELIVERED))
                .collect(Collectors.toList());
    }


    public static <T> void checkIfInputNull(T input) {
        if (input == null) {
            throw new InputCanNotBeNullException();
        }
    }

    private void createDefaultData(){
        Customer customer = customerBuilder().withFirstName("John").withLastName("Doe").build();
        Item smartphone = itemBuilder().withStockAmount(10).withName("Laptop")
                .withPrice(new Price(700, EURO)).build();
        Item laptop = itemBuilder().withStockAmount(10).withName("Smarthone")
                .withPrice(new Price(700, EURO)).build();
        List<Item> items = List.of(smartphone, laptop);
        Order order = new Order(customer, items);
        order.addItemToOrder(smartphone, 2);
        order.addItemToOrder(laptop, 1);
        orderDatabase.put(order.getID(), order);
    }
}
