package com.cml.eurder.service.item;

import com.cml.eurder.domain.item.Price;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDto {
    private String id;
    private String name;
    private String description;
    private int stockAmount;
    private Price price;
    private boolean available;

    public ItemDto() {
    }

//    @JsonCreator
//    public ItemDto(@JsonProperty String id, @JsonProperty String name, @JsonProperty String description,
//                   @JsonProperty int stockAmount,@JsonProperty Price price, @JsonProperty boolean available) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.stockAmount = stockAmount;
//        this.price = price;
//        this.available = available;
//    }


    public ItemDto(String id, String name, String description, int stockAmount, Price price, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stockAmount = stockAmount;
        this.price = price;
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public Price getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }
}
