package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.enums.ClothingSize;
import com.paulo.FloodSupport.core.domain.enums.UnitMeasurement;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Item item = new Clothing("Camisa", "Gola polo preta", "f", ClothingSize.M);
        Item item1 = new Food("Arroz", "Arroz parbolizado", 5.0, UnitMeasurement.KG, LocalDate.now());

        System.out.println(item1.getItemDetails());
    }
}
