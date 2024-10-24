package com.paulo.FloodSupport.core.usecase.shelter;

import com.paulo.FloodSupport.core.domain.Shelter;

import java.util.List;

public interface SheltersSorterByCapacityUseCase {

    List<Shelter> getSheltersSortedByCapacity();
}
