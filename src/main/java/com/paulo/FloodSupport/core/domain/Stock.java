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

        quantityPerCategory.put(category, quantityPerCategory.getOrDefault(category, 0) + quantity);

        quantityPerItem.putIfAbsent(category, new LinkedHashMap<>());
        Map<String, Integer> itemCategory = quantityPerItem.get(category);
        itemCategory.put(itemName, itemCategory.getOrDefault(itemName, 0) + quantity);
    }

    public int getTotalQuantityPerCategory(ItemType itemType) {
        return quantityPerCategory.getOrDefault(itemType, 0);
    }

    public int getQuantityPerItem(ItemType itemType, String itemName) {
        Map<String, Integer> itemCategory = quantityPerItem.getOrDefault(itemType, new LinkedHashMap<>());
        return itemCategory.getOrDefault(itemName, 0);
    }
}
