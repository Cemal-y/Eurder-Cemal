package com.cml.eurder.domain.item;

import com.cml.eurder.domain.exceptions.InputCanNotBeNullException;
import com.cml.eurder.domain.exceptions.ItemIsNotAvailableException;
import com.cml.eurder.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private ConcurrentHashMap<String, Item> itemDatabase;

    public ItemRepository() {
        this.itemDatabase = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<String, Item> getItemDatabase() {
        return itemDatabase;
    }

    public Collection<Item> getAllItems(){
        return itemDatabase.values();
    }

    public Item addItem(Item item){
        checkIfInputNull(item);
//        checkIfItemIsAvailable(item);
        itemDatabase.put(item.getId(), item);
        return item;
    }

    public Item getItemById(String id){
        return itemDatabase.get(id);
    }



//    private void checkIfItemIsAvailable(Item item) {
//        if (!item.isAvailable()){
//            throw new ItemIsNotAvailableException();
//        }
//    }


    public static <T> void checkIfInputNull(T input) {
        if (input == null) {
            throw new InputCanNotBeNullException();
        }
    }
}
