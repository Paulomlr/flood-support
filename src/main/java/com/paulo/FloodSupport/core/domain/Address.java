package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.exceptions.InvalidZipCodeException;

import java.util.Objects;

public class Address {

    private Long addressId;

    private String street;
    private String number;
    private String district;
    private String city;
    private String state;
    private String zipCode;

    public Address(Long addressId, String street, String number, String district, String city, String state, String zipCode) {
        if(!isValidZipCode(zipCode)) {
            throw new InvalidZipCodeException("Invalid zip code");
        }
        this.addressId = addressId;
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(String street, String number, String district, String city, String state, String zipCode) {
        if(!isValidZipCode(zipCode)) {
            throw new InvalidZipCodeException("Invalid zip code");
        }
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address() {
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public boolean isValidZipCode(String zipCode) {
        return zipCode.matches("^[0-9]{5}[-]?[0-9]{3}$");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressId, address.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(addressId);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
