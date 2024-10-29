package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.enums.ItemType;
import com.paulo.FloodSupport.core.domain.enums.UnitMeasurement;

import java.time.LocalDate;
import java.util.UUID;

public class Food extends Item{

    private Double weight;
    private UnitMeasurement unitMeasurement;
    private LocalDate expirationDate;

    public Food(UUID itemId, String name, String description, Double weight, UnitMeasurement unitMeasurement, LocalDate expirationDate) {
        super(itemId, name, ItemType.FOODS, description);
        this.weight = weight;
        this.unitMeasurement = unitMeasurement;
        this.expirationDate = expirationDate;
    }

    public Food(String name, String description, Double weight, UnitMeasurement unitMeasurement, LocalDate expirationDate) {
        super(name, ItemType.FOODS, description);
        this.weight = weight;
        this.unitMeasurement = unitMeasurement;
        this.expirationDate = expirationDate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public UnitMeasurement getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(UnitMeasurement unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String getItemDetails() {
        return "Id: " + getItemId() +
                "\nName: " + getName() +
                "\nDescription: " + getDescription() +
                "\nWeight: " + this.weight + " " + this.unitMeasurement +
                "\nExpirationDate: " + this.expirationDate;
    }
}
