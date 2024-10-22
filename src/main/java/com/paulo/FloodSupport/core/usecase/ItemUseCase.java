package com.paulo.FloodSupport.core.usecase;

import com.paulo.FloodSupport.core.domain.Item;

import java.util.List;

public interface ItemUseCase {

    void create(Item item);
    List<Item> getAllItems();
}
