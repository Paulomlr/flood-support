package com.paulo.FloodSupport.application.gateways;

import com.paulo.FloodSupport.core.domain.Donation;

public interface DonationRepository {

    Donation create (Donation donation);
}
