package com.paulo.FloodSupport.core.usecase.distributionCenter;

import com.paulo.FloodSupport.core.domain.Donation;

public interface ProcessDonationReceivedUseCase {

    void processDonation(Donation donation);
}
