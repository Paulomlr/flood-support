package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.enums.ItemType;

import java.util.UUID;

public class HygieneProduct extends Item {

    public HygieneProduct(UUID itemId, String name, String description) {
        super(itemId, name, ItemType.HYGIENE_PRODUCTS, description);
    }

    public HygieneProduct(String name, String description) {
        super(name, ItemType.HYGIENE_PRODUCTS, description);
    }

    @Override
    public String getItemDetails() {
        return  "Id: " + getItemId() + "\n" +
                "Name: " + getName() + "\n" +
                "Description: " + getDescription();
    }
}
