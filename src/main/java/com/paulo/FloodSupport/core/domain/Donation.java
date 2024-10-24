package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.exceptions.ValidationException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Donation {

    private UUID donationId;

    private Donor donor;
    private LocalDateTime sendDate;
    private List<DonationItem> items;

    public Donation(UUID donationId, Donor donor) {
        this.donationId = donationId;
        this.donor = donor;
        this.sendDate = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public Donation(Donor donor) {
        this.donor = donor;
        this.sendDate = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public Donation() {
        this.sendDate = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public UUID getDonationId() {
        return donationId;
    }

    public Donor getDonor() {
        return donor;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }


    public List<DonationItem> getItems() {
        return items;
    }

    public void addItem(DonationItem item) {
        this.items.add(item);
    }

    public void removeItem(DonationItem item) {
        if(!this.items.contains(item)) {
            throw new ValidationException("Item not found in the donation list");
        }
        this.items.remove(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return Objects.equals(donationId, donation.donationId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(donationId);
    }

    @Override
    public String toString() {
        return "Donation{" +
                "donationId=" + donationId +
                ", donor=" + donor +
                ", sendDate=" + sendDate +
                ", items=" + items +
                '}';
    }
}
