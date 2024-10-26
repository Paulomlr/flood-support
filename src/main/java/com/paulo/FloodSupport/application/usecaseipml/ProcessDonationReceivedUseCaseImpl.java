package com.paulo.FloodSupport.application.usecaseipml;

import com.paulo.FloodSupport.application.gateways.DistributionCenterRepository;
import com.paulo.FloodSupport.core.domain.DistributionCenter;
import com.paulo.FloodSupport.core.domain.Donation;
import com.paulo.FloodSupport.core.domain.DonationItem;
import com.paulo.FloodSupport.core.domain.exceptions.DistributionCenterNotFoundException;
import com.paulo.FloodSupport.core.domain.exceptions.ItemCapacityExceededException;
import com.paulo.FloodSupport.core.usecase.distributionCenter.ProcessDonationReceivedUseCase;

import java.util.UUID;

public class ProcessDonationReceivedUseCaseImpl implements ProcessDonationReceivedUseCase {

    private final DistributionCenterRepository distributionCenterRepository;

    public ProcessDonationReceivedUseCaseImpl(DistributionCenterRepository distributionCenterRepository) {
        this.distributionCenterRepository = distributionCenterRepository;
    }

    @Override
    public void processDonation(UUID distributionCenterId, Donation donation) {
        DistributionCenter distributionCenter = distributionCenterRepository.find(distributionCenterId)
                .orElseThrow(() -> new DistributionCenterNotFoundException("Distribution center not found"));

        for(DonationItem donationItem : donation.getItems()) {
            if(!distributionCenter.canStore(donationItem.getItem(), donationItem.getQuantity())) {
                throw new ItemCapacityExceededException("Item capacity exceeded for: " + donationItem.getItem().getName());
            }
        }
        distributionCenter.addDonation(donation);
        distributionCenterRepository.save(distributionCenter);
    }
}
