package com.cml.eurder.domain.item;

import java.time.LocalDate;
import java.util.UUID;

public class Item implements Orderable {
    private String id;
    private String name;
    private String description;
    private int stockAmount;
    private Price price;
    private boolean available;
    private LocalDate shippingDate;
//    private int itemAmount;

    public Item() {
        setShippingDate();
    }

    public Item(ItemBuilder itemBuilder) {
        this.id = UUID.randomUUID().toString();
        this.name = itemBuilder.name;
        this.description = itemBuilder.description;
        this.stockAmount = itemBuilder.stockAmount;
        this.price = itemBuilder.price;
//        this.itemAmount = itemBuilder.itemAmount;
//        setItemToAvailableIfStockISEnough();
        setShippingDate();
    }

    public void setShippingDate() {
        if(stockAmount > 0){
            shippingDate = LocalDate.now().plusDays(1);
        } else {
            shippingDate = LocalDate.now().plusWeeks(1);
        }

    }

    public void deductFromStockAmount(int stockAmount) {
        this.stockAmount -= stockAmount;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }


    public Item setPrice(Price price) {
        this.price = price;
        return this;
    }

    public Item setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
        return this;
    }
    //    private void setItemToAvailableIfStockISEnough() {
//        if(stockAmount != 0){
//            this.available = true;
//        }
//    }


    public boolean isAvailable() {
        return available;
    }


//    public void setItemAmount(int itemAmount) {
//        this.itemAmount = itemAmount;
//    }
//
//    public int getItemAmount() {
//        return itemAmount;
//    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Price getPrice() {
        return price;
    }

    @Override
    public int getStockAmount() {
        return stockAmount;
    }

    @Override
    public String getId() {
        return id;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public static class ItemBuilder {
        private String name;
        private String description;
        private int stockAmount;
        private Price price;
//        private int itemAmount;

        private ItemBuilder() {
        }

        public static ItemBuilder itemBuilder() {
            return new ItemBuilder();
        }
        public Item build() {
            return new Item(this);
        }

        public ItemBuilder withName(String name) {
            this.name = name;
            return this;
        }
        public ItemBuilder withDescription(String description) {
            this.description = description;
            return this;
        }
        public ItemBuilder withStockAmount(int stockAmount) {
            this.stockAmount = stockAmount;
            return this;
        }
        public ItemBuilder withPrice(Price price) {
            this.price = price;
            return this;
        }
//        public ItemBuilder withItemAmount(int itemAmount) {
//            this.itemAmount = itemAmount;
//            return this;
//        }
    }
}
