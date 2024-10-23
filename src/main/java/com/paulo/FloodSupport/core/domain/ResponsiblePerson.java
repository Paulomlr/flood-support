package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.exceptions.ValidationException;

import java.util.Objects;
import java.util.UUID;

public class ResponsiblePerson {

    private UUID responsiblePersonId;

    private String name;
    private String phoneNumber;
    private String email;

    public ResponsiblePerson(UUID responsiblePersonId, String name, String phoneNumber, String email) {
        validatePhoneNumber(phoneNumber);
        validateEmail(email);
        this.responsiblePersonId = responsiblePersonId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public ResponsiblePerson(String name, String email, String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        validateEmail(email);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public ResponsiblePerson() {
    }

    public UUID getResponsiblePersonId() {
        return responsiblePersonId;
    }

    public void setResponsiblePersonId(UUID responsiblePersonId) {
        this.responsiblePersonId = responsiblePersonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-zA-Z]{2,}$");
    }

    private void validateEmail(String email) {
        if(!isValidEmail(email)) {
            throw new ValidationException("Invalid email");
        }
    }
    
    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^[(]?[0-9]{2}[)]?\\s?[0-9]{5}[-]?[0-9]{4}$");
    }

    private void validatePhoneNumber(String phoneNumber) {
        if(!isValidPhoneNumber(phoneNumber)) {
            throw new ValidationException("PhoneNumber invalid");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsiblePerson that = (ResponsiblePerson) o;
        return Objects.equals(responsiblePersonId, that.responsiblePersonId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(responsiblePersonId);
    }

    @Override
    public String toString() {
        return "ResponsiblePerson{" +
                "responsiblePersonId=" + responsiblePersonId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
