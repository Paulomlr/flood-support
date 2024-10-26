package com.paulo.FloodSupport.application.usecaseipml;

import com.paulo.FloodSupport.application.gateways.DistributionCenterRepository;
import com.paulo.FloodSupport.core.domain.DistributionCenter;
import com.paulo.FloodSupport.core.usecase.distributionCenter.CreateDistributionCenterUseCase;

public class CreateDistributionCenterUseCaseImpl implements CreateDistributionCenterUseCase {

    private final DistributionCenterRepository distributionCenterRepository;

    public CreateDistributionCenterUseCaseImpl(DistributionCenterRepository distributionCenterRepository) {
        this.distributionCenterRepository = distributionCenterRepository;
    }

    @Override
    public void create(DistributionCenter distributionCenter) {
        distributionCenterRepository.create(distributionCenter);
    }
}
