package com.paulo.FloodSupport.application.usecaseipml;

import com.paulo.FloodSupport.application.gateways.DistributionCenterRepository;
import com.paulo.FloodSupport.core.domain.DistributionCenter;
import com.paulo.FloodSupport.core.usecase.distributionCenter.AllDistributionCenterUseCase;

import java.util.List;

public class AllDistributionCenterUseCaseImpl implements AllDistributionCenterUseCase {

    private final DistributionCenterRepository distributionCenterRepository;

    public AllDistributionCenterUseCaseImpl(DistributionCenterRepository distributionCenterRepository) {
        this.distributionCenterRepository = distributionCenterRepository;
    }

    @Override
    public List<DistributionCenter> getAllCenters() {
        return distributionCenterRepository.getAll();
    }
}
