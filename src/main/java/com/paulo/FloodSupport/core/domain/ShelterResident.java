package com.paulo.FloodSupport.core.domain;

import com.paulo.FloodSupport.core.domain.exceptions.InvalidSexException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ShelterResident {

    private UUID shelterResidentId;

    private String name;
    private Integer age;
    private String sex;
    private LocalDateTime entryDate;
    private LocalDateTime departureDate;

    public ShelterResident(UUID shelterResidentId, String name, Integer age, String sex, LocalDateTime entryDate, LocalDateTime departureDate) {
        if(!isValidSex(sex)) {
            throw new InvalidSexException("Invalid sex");
        }
        this.shelterResidentId = shelterResidentId;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
    }

    public ShelterResident(String name, Integer age, String sex, LocalDateTime entryDate, LocalDateTime departureDate) {
        if(!isValidSex(sex)) {
            throw new InvalidSexException("Invalid sex");
        }
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
    }

    public ShelterResident() {
    }

    public UUID getShelterResidentId() {
        return shelterResidentId;
    }

    public void setShelterResidentId(UUID shelterResidentId) {
        this.shelterResidentId = shelterResidentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public boolean isValidSex(String sex) {
        return sex.matches("^[FfMm]$");
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
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", entryDate=" + entryDate +
                ", departureDate=" + departureDate +
                '}';
    }
}
