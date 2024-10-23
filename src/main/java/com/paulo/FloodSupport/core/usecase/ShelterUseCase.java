package com.paulo.FloodSupport.core.usecase;

import com.paulo.FloodSupport.core.domain.Shelter;
import com.paulo.FloodSupport.core.domain.ShelterResident;

import java.util.List;
import java.util.UUID;

public interface ShelterUseCase {

    void create(Shelter shelter);
    void addShelterResident(UUID shelterID, ShelterResident shelterResident) ;
    void removeShelterResident(UUID shelterId, UUID shelterResidentId);
    List<Shelter> getAllShelters();
    List<Shelter> getSheltersSortedByOccupation();
    List<Shelter> getSheltersSortedByCapacity();
}
