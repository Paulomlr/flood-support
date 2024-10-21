package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.exceptions.InvalidBirthDateException;
import com.paulo.FloodSupport.core.domain.exceptions.InvalidDateRangeException;
import com.paulo.FloodSupport.core.domain.exceptions.InvalidSexException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;
import java.util.UUID;

public class ShelterResident {

    private UUID shelterResidentId;

    private String name;
    private LocalDate birthDate;
    private String sex;
    private LocalDateTime entryDate;
    private LocalDateTime departureDate;

    public ShelterResident(UUID shelterResidentId, String name, LocalDate birthDate, String sex, LocalDateTime entryDate, LocalDateTime departureDate) {
        validateSex(sex);
        validateBirthDate(birthDate);
        validateDateRange(departureDate);

        this.shelterResidentId = shelterResidentId;
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.entryDate = LocalDateTime.now();
        this.departureDate = departureDate;
    }

    public ShelterResident(String name, LocalDate birthDate, String sex, LocalDateTime entryDate, LocalDateTime departureDate) {
        validateSex(sex);
        validateBirthDate(birthDate);
        validateDateRange(departureDate);

        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.entryDate = LocalDateTime.now();
        this.departureDate = departureDate;
    }

    public ShelterResident(String name, LocalDate birthDate, String sex, LocalDateTime entryDate) {
        validateSex(sex);
        validateBirthDate(birthDate);

        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.entryDate = LocalDateTime.now();
    }

    public ShelterResident() {
    }

    public UUID getShelterResidentId() {
        return shelterResidentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        validateSex(sex);
        this.sex = sex;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        validateDateRange(departureDate);
        this.departureDate = departureDate;
    }

    private boolean isValidSex(String sex) {
        return sex.matches("^[FfMm]$");
    }

    private void validateSex(String sex) {
        if(!isValidSex(sex)) {
            throw new InvalidSexException("Invalid sex");
        }
    }

    private void validateBirthDate(LocalDate birthDate) {
        if(birthDate.isAfter(LocalDate.now())) {
            throw new InvalidBirthDateException("Birth date cannot be in the future");
        }
    }

    private void validateDateRange(LocalDateTime departureDate) {
        if(departureDate.isBefore(this.entryDate)) {
            throw new InvalidDateRangeException("The departure date cannot be earlier than the entry date.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShelterResident that = (ShelterResident) o;
        return Objects.equals(shelterResidentId, that.shelterResidentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(shelterResidentId);
    }

    @Override
    public String toString() {
        return "ShelterResident{" +
                "shelterResidentId=" + shelterResidentId +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", sex='" + sex + '\'' +
                ", entryDate=" + entryDate +
                ", departureDate=" + departureDate +
                '}';
    }
}
