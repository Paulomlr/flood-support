package com.paulo.FloodSupport.core.usecase.shelter;

import com.paulo.FloodSupport.core.domain.ShelterResident;

import java.util.UUID;

public interface ShelterResidentUseCase {

    void add(UUID shelterID, ShelterResident shelterResident);
    void remove(UUID shelterId, UUID shelterResidentId);
}
