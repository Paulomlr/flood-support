package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.enums.DonorType;
import com.paulo.FloodSupport.core.domain.exceptions.InvalidDocumentException;
import com.paulo.FloodSupport.core.domain.exceptions.InvalidEmailException;
import com.paulo.FloodSupport.core.domain.exceptions.InvalidPhoneNumberException;

import java.util.Objects;
import java.util.UUID;

public class Donor {

    private UUID donorId;

    private String name;
    private DonorType donorType;
    private String cpfCnpj;
    private String email;
    private String phoneNumber;

    public Donor(UUID donorId, String name, DonorType donorType, String cpfCnpj, String email, String phoneNumber) {
        validateCpfCnpj(cpfCnpj);
        validateEmail(email);
        validatePhoneNumber(phoneNumber);
        this.donorId = donorId;
        this.name = name;
        this.donorType = donorType;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Donor(String name, DonorType donorType, String cpfCnpj, String email, String phoneNumber) {
        validateCpfCnpj(cpfCnpj);
        validateEmail(email);
        validatePhoneNumber(phoneNumber);
        this.name = name;
        this.donorType = donorType;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Donor() {
    }

    public UUID getDonorId() {
        return donorId;
    }

    public void setDonorId(UUID donorId) {
        this.donorId = donorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DonorType getDonorType() {
        return donorType;
    }

    public void setDonorType(DonorType donorType) {
        this.donorType = donorType;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        validateCpfCnpj(cpfCnpj);
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-zA-Z]{2,}$");
    }

    private void validateEmail(String email) {
        if(!isValidEmail(email)) {
            throw new InvalidEmailException("Invalid email");
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^[(]?[0-9]{2}[)]?\\s?[0-9]{5}[-]?[0-9]{4}$");
    }

    private void validatePhoneNumber(String phoneNumber) {
        if(!isValidPhoneNumber(phoneNumber)) {
            throw new InvalidPhoneNumberException("PhoneNumber invalid");
        }
    }

    private boolean isValidCpfCnpj(String cpfCnpj) {
        return cpfCnpj.matches("^([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2}|[0-9]{2}[.][0-9]{3}[.][0-9]{3}[/][0-9]{4}[-][0-9]{2})$");
    }

    private void validateCpfCnpj(String cpfCnpj) {
        if(!isValidCpfCnpj(cpfCnpj)) {
            throw new InvalidDocumentException("Invalid document");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donor donor = (Donor) o;
        return Objects.equals(donorId, donor.donorId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(donorId);
    }

    @Override
    public String toString() {
        return "Donor{" +
                "donorId=" + donorId +
                ", name='" + name + '\'' +
                ", donorType=" + donorType +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
