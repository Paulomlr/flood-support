package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.enums.ItemType;

import java.util.LinkedHashMap;
import java.util.Map;

public class Stock {

    private Map<ItemType, Integer> quantityPerCategory;
    private Map<ItemType, Map<String, Integer>> quantityPerItem;

    public Stock() {
        quantityPerCategory = new LinkedHashMap<>();
        quantityPerItem = new LinkedHashMap<>();
    }

    public void addItem(Item item, int quantity) {
        ItemType category = item.getItemType();
        String itemName = item.getName();

        if(quantity <= 0) {
            throw new IllegalArgumentException("The quantity to be added must be greater than zero.");
        }

        quantityPerCategory.put(category, quantityPerCategory.getOrDefault(category, 0) + quantity);

        quantityPerItem.putIfAbsent(category, new LinkedHashMap<>());
        Map<String, Integer> itemCategory = quantityPerItem.get(category);
        itemCategory.put(itemName, itemCategory.getOrDefault(itemName, 0) + quantity);
    }

    public void removeItem(Item item, int quantity) {
        ItemType category = item.getItemType();
        String itemName = item.getName();

        int currentCategoryQuantity = quantityPerCategory.getOrDefault(category, 0);
        if (quantity > currentCategoryQuantity) {
            throw new IllegalArgumentException("The quantity to be removed exceeds the total available in the category");
        }

        Map<String, Integer> itemCategory = quantityPerItem.getOrDefault(category, new LinkedHashMap<>());
        int currentItemQuantity = itemCategory.getOrDefault(itemName, 0);
        if (quantity > currentItemQuantity) {
            throw new IllegalArgumentException("The quantity to be removed exceeds the total items available");
        }

        quantityPerCategory.put(category, quantityPerCategory.getOrDefault(category, 0) - quantity);
        itemCategory.put(itemName, currentItemQuantity - quantity);

        if (itemCategory.get(itemName) == 0) {
            itemCategory.remove(itemName);
        }

        if (quantityPerCategory.get(category) == 0) {
            quantityPerCategory.remove(category);
        }
    }

    public int getTotalQuantityPerCategory(ItemType itemType) {
        return quantityPerCategory.getOrDefault(itemType, 0);
    }

    public int getQuantityPerItem(ItemType itemType, String itemName) {
        Map<String, Integer> itemCategory = quantityPerItem.getOrDefault(itemType, new LinkedHashMap<>());
        return itemCategory.getOrDefault(itemName, 0);
    }
}
