package com.paulo.FloodSupport.core.usecase.distributionCenter;

import com.paulo.FloodSupport.core.domain.Donation;

import java.util.UUID;

public interface ProcessDonationReceivedUseCase {

    void processDonation(UUID distributionCenterId, Donation donation);
}
