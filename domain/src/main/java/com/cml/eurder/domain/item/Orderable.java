package com.cml.eurder.domain.item;

public interface Orderable {
    String getName();
    String getDescription();
    Price getPrice();
    int getAmount();
    String getId();
}
