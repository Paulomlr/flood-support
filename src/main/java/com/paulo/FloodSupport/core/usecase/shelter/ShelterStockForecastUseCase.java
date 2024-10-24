package com.paulo.FloodSupport.core.usecase.shelter;

import java.time.LocalDate;
import java.util.UUID;

public interface ShelterStockForecastUseCase {

    LocalDate stockForecast(UUID shelterId);
}
