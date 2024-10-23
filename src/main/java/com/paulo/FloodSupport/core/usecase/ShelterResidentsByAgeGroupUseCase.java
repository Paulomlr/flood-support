package com.paulo.FloodSupport.core.usecase;

import com.paulo.FloodSupport.core.domain.ShelterResident;

import java.util.List;
import java.util.UUID;

public interface ShelterResidentsByAgeGroupUseCase {

    List<ShelterResident> getShelterResidents(UUID shelterId);
}
