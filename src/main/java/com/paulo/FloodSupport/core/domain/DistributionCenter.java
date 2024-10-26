package com.paulo.FloodSupport.core.domain;

import java.util.*;

public class DistributionCenter {
    private static final int MAX_ITEM_CAPACITY = 1000;

    private UUID distributionCenterId;

    private String name;
    private Address address;
    private ResponsiblePerson responsiblePerson;
    private List<Donation> donations;
    private List<Order> ordersReceived;
    private Map<Item, Integer> stock;

    public DistributionCenter(UUID distributionCenterId, String name, Address address, ResponsiblePerson responsiblePerson) {
        this.distributionCenterId = distributionCenterId;
        this.name = name;
        this.address = address;
        this.responsiblePerson = responsiblePerson;
        this.donations = new ArrayList<>();
        this.ordersReceived = new ArrayList<>();
        this.stock = new LinkedHashMap<>();
    }

    public DistributionCenter(String name, Address address, ResponsiblePerson responsiblePerson) {
        this.name = name;
        this.address = address;
        this.responsiblePerson = responsiblePerson;
        this.donations = new ArrayList<>();
        this.ordersReceived = new ArrayList<>();
        this.stock = new LinkedHashMap<>();
    }

    public DistributionCenter() {
        this.donations = new ArrayList<>();
        this.ordersReceived = new ArrayList<>();
        this.stock = new LinkedHashMap<>();
    }

    public UUID getDistributionCenterId() {
        return distributionCenterId;
    }

    public void setDistributionCenterId(UUID distributionCenterId) {
        this.distributionCenterId = distributionCenterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ResponsiblePerson getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(ResponsiblePerson responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public Map<Item, Integer> getStock() {
        return stock;
    }

    public void addOrder(Order order) {
        this.ordersReceived.add(order);
    }

    public List<Order> getOrdersReceived() {
        return ordersReceived;
    }

    public void addDonation(Donation donation) {
        for(DonationItem donationItem : donation.getItems()) {
            Item item = donationItem.getItem();
            int currentQuantity = stock.getOrDefault(item, 0);
            stock.put(item, currentQuantity + donationItem.getQuantity());
        }
        this.donations.add(donation);
    }

    public boolean canStore(Item item, int quantityToAdd) {
        int currentQuantity = stock.getOrDefault(item, 0);
        return (currentQuantity + quantityToAdd) <= MAX_ITEM_CAPACITY;
    }

    public void updateStock(Item item, int quantityToDecreased) {
        int currentQuantity = stock.getOrDefault(item, 0);
        stock.put(item, currentQuantity - quantityToDecreased);
    }

    public boolean canSend(Item item, int quantityToAdd) {
        int currentQuantity = stock.getOrDefault(item, 0);
        return (currentQuantity - quantityToAdd) >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistributionCenter that = (DistributionCenter) o;
        return Objects.equals(distributionCenterId, that.distributionCenterId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(distributionCenterId);
    }

    @Override
    public String toString() {
        return "DistributionCenter{" +
                "distributionCenterId=" + distributionCenterId +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", responsiblePerson=" + responsiblePerson +
                ", donations=" + donations +
                ", stock=" + stock +
                '}';
    }
}
