package com.paulo.FloodSupport.core.domain;

import java.util.Objects;

public class DonationItem {

    private Donation donation;
    private Item item;
    private Integer quantity;

    public DonationItem(Donation donation, Item item, Integer quantity) {
        this.donation = donation;
        this.item = item;
        this.quantity = quantity;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonationItem that = (DonationItem) o;
        return Objects.equals(donation, that.donation) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donation, item);
    }

    @Override
    public String toString() {
        return "DonationItem{" +
                "donation=" + donation +
                ", item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
