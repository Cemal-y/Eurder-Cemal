package com.cml.eurder.domain.order;

import com.cml.eurder.domain.item.Item;
import com.cml.eurder.domain.item.Price;
import com.cml.eurder.domain.user.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.cml.eurder.domain.item.Currency.EURO;
import static com.cml.eurder.domain.item.Item.ItemBuilder.itemBuilder;

class OrderTest {
    Item smartPhone = itemBuilder().withPrice(new Price(700, EURO)).withName("Smartphone").withStockAmount(5).build();
    Item laptop = itemBuilder().withPrice(new Price(1000, EURO)).withName("Laptop").withStockAmount(5).build();
    Customer customer1 = Customer.Builder.customerBuilder().withFirstName("John").withLastName("Doe").build();
    Order order = new Order(customer1, List.of(smartPhone));

    @Test
    public void checkIfItemsAddedToOrder(){
        order.addItemToOrder(smartPhone, 3);
        System.out.println(smartPhone.getStockAmount());
    }

}