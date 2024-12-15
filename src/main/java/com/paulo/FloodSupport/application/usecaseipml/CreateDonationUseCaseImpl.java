package com.paulo.FloodSupport.application.usecaseipml;

import com.paulo.FloodSupport.application.gateways.DonationRepository;
import com.paulo.FloodSupport.core.domain.Donation;
import com.paulo.FloodSupport.core.usecase.CreateDonationUseCase;

public class CreateDonationUseCaseImpl implements CreateDonationUseCase {

    private final DonationRepository donationRepository;

    public CreateDonationUseCaseImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public void create(Donation donation) {
        donationRepository.create(donation);
    }
}
