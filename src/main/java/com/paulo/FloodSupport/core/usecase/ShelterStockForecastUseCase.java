package com.paulo.FloodSupport.core.usecase;

import java.time.LocalDate;
import java.util.UUID;

public interface ShelterStockForecastUseCase {

    LocalDate stockForecast(UUID shelterId);
}
