package com.paulo.FloodSupport.core.domain;

import java.util.UUID;

public class HygieneProduct extends Item {

    public HygieneProduct(UUID itemId, String name, String description) {
        super(itemId, name, description);
    }

    public HygieneProduct(String name, String description) {
        super(name, description);
    }

    public HygieneProduct() {
    }

    @Override
    public String getItemDetails() {
        return  "Id: " + getItemId() + "\n" +
                "Name: " + getName() + "\n" +
                "Description: " + getDescription();
    }
}
