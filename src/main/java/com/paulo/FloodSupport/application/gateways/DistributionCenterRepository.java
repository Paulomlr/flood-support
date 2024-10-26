package com.paulo.FloodSupport.application.gateways;

import com.paulo.FloodSupport.core.domain.DistributionCenter;

import java.util.List;
import java.util.UUID;

public interface DistributionCenterRepository {

    DistributionCenter create(DistributionCenter distributionCenter);
    List<DistributionCenter> getAll();
    DistributionCenter find(UUID distributionCenterId);
}
