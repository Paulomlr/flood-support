package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.enums.UnitMeasurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    private Stock stock;

    @BeforeEach
    void setUp() {
        stock = new Stock();
    }

    @Test
    @DisplayName("Should correctly update the total quantity per category when adding an item")
    void testAddItemUpdatesTotalQuantityPerCategory() {
         Item item = new HygieneProduct("Pasta de Dente", "Colgate total 12");

         assertEquals(0, stock.getTotalQuantityPerCategory(item.getItemType()),
                 "The initial quantity must be zero.");

         int quantityToAdd = 50;
         stock.addItem(item, quantityToAdd);

         assertEquals(quantityToAdd, stock.getTotalQuantityPerCategory(item.getItemType()));
    }

    @Test
    @DisplayName("Should correctly update quantity for different categories when adding items")
    void testAddItemsWithDifferentCategoriesUpdatesCorrectQuantity() {
         Item item1 = new HygieneProduct("Pasta de Dente", "Colgate total 12");
         Item item2 = new Food("Arroz", "Tio jorge", 5.0, UnitMeasurement.KG, LocalDate.parse("2023-07-11"));

         int quantityToAddItem1 = 50;
         int quantityToAddItem2 = 200;

         stock.addItem(item1, quantityToAddItem1);
         stock.addItem(item2, quantityToAddItem2);

         assertEquals(quantityToAddItem1, stock.getTotalQuantityPerCategory(item1.getItemType()),
                 "The hygiene amount must be updated correctly.");
         assertEquals(quantityToAddItem2, stock.getTotalQuantityPerCategory(item2.getItemType()),
                 "The amount of food must be updated correctly.");
    }

    @Test
    @DisplayName("It should correctly accumulate the quantity when adding the same item multiple times")
    void testAddSameItemMultipleTimesAccumulatesQuantity() {
         Item item1 = new Food("Arroz", "Tio jorge", 5.0, UnitMeasurement.KG, LocalDate.parse("2023-07-11"));

         int quantityToAddItem1 = 50;
         int quantityToAddItem2 = 200;

         stock.addItem(item1, quantityToAddItem2);
         stock.addItem(item1, quantityToAddItem2);

         assertEquals(quantityToAddItem2 * 2, stock.getQuantityPerItem(item1.getItemType(), item1.getName()),
                 "The accumulated quantity for the item 'Rice' should be correct after multiple additions.");
    }

    @Test
    @DisplayName("Must add and remove items, correctly updating quantities by category and by item")
    void testAddAndRemoveItemsUpdatesQuantitiesCorrectly() {
        Item item1 = new Food("Arroz", "Tio jorge", 5.0, UnitMeasurement.KG, LocalDate.parse("2023-07-11"));
        Item item2 = new Food("Feijão", "Tio jorge", 2.0, UnitMeasurement.KG, LocalDate.parse("2023-09-11"));


        int quantityToAddItem1 = 150;
        int quantityToAddItem2 = 200;

        stock.addItem(item1, quantityToAddItem1);
        stock.addItem(item2, quantityToAddItem2);

        assertEquals(quantityToAddItem1 + quantityToAddItem2, stock.getTotalQuantityPerCategory(item2.getItemType()));
        assertEquals(quantityToAddItem1, stock.getQuantityPerItem(item1.getItemType(), item1.getName()));
        assertEquals(quantityToAddItem2, stock.getQuantityPerItem(item2.getItemType(), item2.getName()));

        stock.removeItem(item2, 50);
        stock.removeItem(item1, 50);

        assertEquals(250, stock.getTotalQuantityPerCategory(item2.getItemType()));
        assertEquals(150, stock.getQuantityPerItem(item2.getItemType(), item2.getName()));
        assertEquals(100, stock.getQuantityPerItem(item1.getItemType(), item1.getName()));
    }

    @Test
    @DisplayName("Should throw an exception when attempting to remove more items than available in stock")
    void testRemoveMoreThanAvailable() {
        Item item = new Food("Arroz", "Tio Jorge", 5.0, UnitMeasurement.KG, LocalDate.parse("2023-07-11"));

        stock.addItem(item, 50);

        assertThrows(IllegalArgumentException.class, () -> {
            stock.removeItem(item, 100);
        });
    }

    @Test
    @DisplayName("Should throw an exception when trying to add an item with zero or negative quantity")
    void testAddItemWithInvalidQuantitiesThrowsException() {
        Item item = new Food("Arroz", "Tio Jorge", 5.0, UnitMeasurement.KG, LocalDate.parse("2023-07-11"));

        assertThrows(IllegalArgumentException.class, () -> {
            stock.addItem(item, 0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            stock.addItem(item, -50);
        });
    }
}