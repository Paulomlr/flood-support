package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.exceptions.ResidentNotFoundException;
import com.paulo.FloodSupport.core.domain.exceptions.ShelterCapacityExceededException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Shelter {

    private static final int MAX_ITEM_CAPACITY = 200;

    private UUID shelterId;

    private String name;
    private Address address;
    private ResponsiblePerson responsiblePerson;
    private Integer shelterCapacity;
    private Integer numberShelterResident;
    private List<ShelterResident> shelterResidents;

    public Shelter(UUID shelterId, String name, Address address, ResponsiblePerson responsiblePerson) {
        this.shelterId = shelterId;
        this.name = name;
        this.address = address;
        this.responsiblePerson = responsiblePerson;
        this.shelterResidents = new ArrayList<>();
    }

    public Shelter(String name, Address address, ResponsiblePerson responsiblePerson) {
        this.name = name;
        this.address = address;
        this.responsiblePerson = responsiblePerson;
        this.shelterResidents = new ArrayList<>();
    }

    public Shelter() {
        this.shelterResidents = new ArrayList<>();
    }

    public UUID getShelterId() {
        return shelterId;
    }

    public void setShelterId(UUID shelterId) {
        this.shelterId = shelterId;
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

    public Integer getNumberShelterResident() {
        return numberShelterResident;
    }

    public void addShelterResident(ShelterResident shelterResident) {
        if(!((this.numberShelterResident + 1) <= this.shelterCapacity)) {
            throw new ShelterCapacityExceededException("Maximum shelter capacity exceeded");
        }
        this.shelterResidents.add(shelterResident);
        numberShelterResident++;
    }

    public void removeShelterResident(ShelterResident shelterResident) {
        if(!this.shelterResidents.contains(shelterResident)) {
            throw new ResidentNotFoundException("Resident not found at shelter");
        }
        this.shelterResidents.remove(shelterResident);
        numberShelterResident--;
    }

    public Double getOccupationPercentage() {
        return (double) numberShelterResident/shelterCapacity * 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelter shelter = (Shelter) o;
        return Objects.equals(shelterId, shelter.shelterId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(shelterId);
    }

    @Override
    public String toString() {
        return "Shelter{" +
                "shelterId=" + shelterId +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", responsiblePerson=" + responsiblePerson +
                ", shelterCapacity=" + shelterCapacity +
                ", numberShelterResident=" + numberShelterResident +
                ", shelterResidents=" + shelterResidents +
                '}';
    }
}
