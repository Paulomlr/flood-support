package com.paulo.FloodSupport.core.domain;

import java.util.UUID;

public abstract class Item {

    private UUID itemId;

    private String name;
    private String description;

    public Item(UUID itemId, String name, String description) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item() {
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract String getItemDetails();
}
