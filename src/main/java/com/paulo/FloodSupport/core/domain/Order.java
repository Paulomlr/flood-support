package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.enums.OrderStatus;
import com.paulo.FloodSupport.core.domain.exceptions.ValidationException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order {

    private UUID orderId;

    private Shelter requestingShelter;
    private DistributionCenter destinationDistributionCenter;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private String rejectionReason;
    private List<OrderItem> items;

    public Order(UUID orderId, Shelter requestingShelter, DistributionCenter destinationDistributionCenter) {
        this.orderId = orderId;
        this.requestingShelter = requestingShelter;
        this.destinationDistributionCenter = destinationDistributionCenter;
        this.orderDate = LocalDateTime.now();
        this.orderStatus = OrderStatus.PENDING;
        this.items = new ArrayList<>();
    }

    public Order(Shelter requestingShelter, DistributionCenter destinationDistributionCenter) {
        this.requestingShelter = requestingShelter;
        this.destinationDistributionCenter = destinationDistributionCenter;
        this.orderDate = LocalDateTime.now();
        this.orderStatus = OrderStatus.PENDING;
        this.items = new ArrayList<>();
    }

    public Order() {
        this.orderDate = LocalDateTime.now();
        this.orderStatus = OrderStatus.PENDING;
        this.items = new ArrayList<>();
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public Shelter getRequestingShelter() {
        return requestingShelter;
    }

    public void setRequestingShelter(Shelter requestingShelter) {
        this.requestingShelter = requestingShelter;
    }

    public DistributionCenter getDestinationDistributionCenter() {
        return destinationDistributionCenter;
    }

    public void setDestinationDistributionCenter(DistributionCenter destinationDistributionCenter) {
        this.destinationDistributionCenter = destinationDistributionCenter;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public void removeItem(OrderItem item) {
        if(!this.items.contains(item)) {
            throw new ValidationException("Item not found in the order list");
        }
        this.items.remove(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", requestingShelter=" + requestingShelter +
                ", destinationDistributionCenter=" + destinationDistributionCenter +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                ", rejectionReason='" + rejectionReason + '\'' +
                ", items=" + items +
                '}';
    }
}
