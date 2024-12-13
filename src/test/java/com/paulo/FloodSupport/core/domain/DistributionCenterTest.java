package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.enums.UnitMeasurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DistributionCenterTest {

    private static final int MAX_ITEM_CAPACITY = 1000;
    private static final int WITHIN_CAPACITY = MAX_ITEM_CAPACITY - 1;
    private static final int EXCEEDS_CAPACITY = MAX_ITEM_CAPACITY + 1;
    private static final int ITEM_QUANTITY = 100;
    private static final int SUFFICIENT_QUANTITY = ITEM_QUANTITY - 1;
    private static final int INSUFFICIENT_QUANTITY = ITEM_QUANTITY + 1;

    private Donation donation;
    private DistributionCenter distributionCenter;
    private Item item1;

    @BeforeEach
    void setUp() {
        donation = new Donation();
        item1 = createFoodItem();
        DonationItem donationItem = new DonationItem(donation, item1, ITEM_QUANTITY);
        donation.addItem(donationItem);
        distributionCenter = createDefaultDistributionCenter();
    }

    @Test
    @DisplayName("Must add a donation correctly to the distribution center")
    void testAddingDonationsToTheDistributionCenter() {
        assertTrue(distributionCenter.getDonations().isEmpty());

        distributionCenter.addDonation(donation);

        assertEquals(1, distributionCenter.getDonations().size());
        assertTrue(distributionCenter.getDonations().contains(donation));
    }

    @Test
    @DisplayName("Should allow storage of an item when it is within storage capacity")
    void shouldAllowStoringItemWithinCapacity() {
        assertTrue(distributionCenter.canStore(item1, WITHIN_CAPACITY));
    }

    @Test
    @DisplayName("Should not allow storing an item when exceeding the storage capacity")
    void shouldNotAllowStoringItemBeyondCapacity() {
        assertFalse(distributionCenter.canStore(item1, EXCEEDS_CAPACITY));
    }

    @Test
    @DisplayName("Tests whether item can be shipped when there is sufficient stock")
    void shouldReturnTrueWhenSufficientStockAvailableForItem() {
        distributionCenter.addDonation(donation);

        assertTrue(distributionCenter.canSend(item1, SUFFICIENT_QUANTITY));
    }

    @Test
    @DisplayName("Tests whether item cannot be shipped when stock is insufficient")
    void shouldReturnFalseWhenStockInsufficientForRequestedQuantity() {
        distributionCenter.addDonation(donation);

        assertFalse(distributionCenter.canSend(item1, INSUFFICIENT_QUANTITY));
    }

    @Test
    @DisplayName("Tests the storage of different items")
    void shouldHandleDifferentTypesOfItemsToCheckStorage() {
        Item item2 = new HygieneProduct("Pasta de dente", "Colgate");
        distributionCenter.addDonation(donation);

        assertFalse(distributionCenter.canStore(item1, MAX_ITEM_CAPACITY), "it should not be possible to store more than a thousand items of the same type");
        assertTrue(distributionCenter.canStore(item2, MAX_ITEM_CAPACITY));
    }

    private DistributionCenter createDefaultDistributionCenter() {
        Address address = new Address("Av. Boqueirão", "2450", "Igara", "Canoas", "RS", "92032-420");
        ResponsiblePerson responsiblePerson = new ResponsiblePerson("Rodrigo Silva", "rodrigosilva27@gmail.com", "91123456789");
        return new DistributionCenter("Centro de Distribuição Esperança", address, responsiblePerson);
    }

    private Item createFoodItem() {
        return new Food("Arroz", "Tio Jorge", 5.0, UnitMeasurement.KG, LocalDate.now().minusDays(10));
    }
}