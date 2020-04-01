package com.cml.eurder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.cml.eurder.domain.Item.ItemBuilder.itemBuilder;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();
    Item item1 = itemBuilder().build();

    @Test
    void checkIfItemIsAddedToDataBase(){
        itemRepository.addItem(item1);
        Assertions.assertTrue(itemRepository.getAllItems().containsKey(item1.getId()));
    }

}