package com.cml.eurder.domain.item;

import com.cml.eurder.domain.item.Item;
import com.cml.eurder.domain.item.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.cml.eurder.domain.item.Item.ItemBuilder.itemBuilder;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();
    Item item1 = itemBuilder().build();

    @Test
    void checkIfItemIsAddedToDataBase(){
        itemRepository.addItem(item1);
        Assertions.assertTrue(itemRepository.getAllItems().containsKey(item1.getId()));
    }

}