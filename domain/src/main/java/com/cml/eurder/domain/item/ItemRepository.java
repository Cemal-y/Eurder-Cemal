package com.cml.eurder.domain.item;

import com.cml.eurder.domain.exceptions.InputCanNotBeNullException;
import com.cml.eurder.domain.exceptions.ItemIsNotAvailableException;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private ConcurrentHashMap<String, Item> itemDatabase;

    public ItemRepository() {
        this.itemDatabase = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<String, Item> getAllItems() {
        return itemDatabase;
    }

    public Item addItem(Item item){
        checkIfInputNull(item);
        if (!item.isAvailable()){
            throw new ItemIsNotAvailableException();
        }
            itemDatabase.put(item.getId(), item);
            return item;
    }


    public static <T> void checkIfInputNull(T input) {
        if (input == null) {
            throw new InputCanNotBeNullException();
        }
    }
}
