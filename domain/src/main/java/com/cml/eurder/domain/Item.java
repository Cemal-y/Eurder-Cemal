package com.cml.eurder.domain;

public class Item implements Orderable {
    private String id;
    private String name;
    private String description;
    private int stockAmount;
    private Price price;

    public Item(ItemBuilder itemBuilder) {
        this.id = itemBuilder.id;
        this.name = itemBuilder.name;
        this.description = itemBuilder.description;
        this.stockAmount = itemBuilder.stockAmount;
        this.price = itemBuilder.price;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Price getPrice() {
        return null;
    }

    @Override
    public int getAmount() {
        return 0;
    }

    public static class ItemBuilder {
        private String id;
        private String name;
        private String description;
        private int stockAmount;
        private Price price;

        private ItemBuilder() {
        }

        public static ItemBuilder itemBuilder() {
            return new ItemBuilder();
        }
        public Item build() {
            return new Item(this);
        }

        public ItemBuilder withId(String id) {
            this.id = id;
            return this;
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
    }
}
