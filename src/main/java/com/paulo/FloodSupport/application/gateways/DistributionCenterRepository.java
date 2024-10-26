package com.paulo.FloodSupport.application.gateways;

import com.paulo.FloodSupport.core.domain.DistributionCenter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DistributionCenterRepository {

    DistributionCenter create(DistributionCenter distributionCenter);
    DistributionCenter save(DistributionCenter distributionCenter);
    List<DistributionCenter> getAll();
    Optional<DistributionCenter> find(UUID distributionCenterId);
}
