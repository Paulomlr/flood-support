package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.enums.ItemType;

import java.util.UUID;

public abstract class Item {

    private UUID itemId;

    private String name;
    private ItemType itemType;
    private String description;

    public Item(UUID itemId, String name, ItemType itemType, String description) {
        this.itemId = itemId;
        this.name = name;
        this.itemType = itemType;
        this.description = description;
    }

    public Item(String name, ItemType itemType, String description) {
        this.name = name;
        this.itemType = itemType;
        this.description = description;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
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
