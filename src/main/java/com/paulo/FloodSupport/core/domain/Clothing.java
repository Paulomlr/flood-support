package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.enums.ClothingSize;
import com.paulo.FloodSupport.core.domain.exceptions.InvalidSexException;

import java.util.UUID;

public class Clothing extends Item{

    private String gender;
    private ClothingSize size;

    public Clothing(UUID itemId, String name, String description, String gender, ClothingSize size) {
        super(itemId, name, description);
        validateGender(gender);
        this.gender = gender;
        this.size = size;
    }

    public Clothing(String name, String description, String gender, ClothingSize size) {
        super(name, description);
        validateGender(gender);
        this.gender = gender;
        this.size = size;
    }

    public Clothing() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ClothingSize getSize() {
        return size;
    }

    public void setSize(ClothingSize size) {
        this.size = size;
    }

    private boolean isValidGender(String gender) {
        return gender.matches("^[FfMm]$");
    }

    private void validateGender(String gender) {
        if(!isValidGender(gender)) {
            throw new InvalidSexException("Invalid sex");
        }
    }

    @Override
    public String getItemDetails() {
        return "Id: " + getItemId() +
                "\nName: " + getName() +
                "\nDescription: " + getDescription() +
                "\nGender: " + this.gender +
                "\nSize: " + this.size;
    }
}