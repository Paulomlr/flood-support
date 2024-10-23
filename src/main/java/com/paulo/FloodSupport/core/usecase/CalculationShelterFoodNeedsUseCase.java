package com.paulo.FloodSupport.core.usecase;

import com.paulo.FloodSupport.core.domain.Item;
import com.paulo.FloodSupport.core.domain.enums.UnitMeasurement;

import java.util.Map;
import java.util.UUID;

public interface CalculationShelterFoodNeedsUseCase {

    Map<Item, Map<Double, UnitMeasurement>> calculateFoodNeeds(UUID shelterId);
}
