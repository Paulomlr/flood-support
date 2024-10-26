package com.paulo.FloodSupport.application.usecaseipml;

import com.paulo.FloodSupport.application.gateways.AddressRepository;
import com.paulo.FloodSupport.core.domain.Address;
import com.paulo.FloodSupport.core.usecase.CreateAddressUseCase;

public class CreateAddressUseCaseImpl implements CreateAddressUseCase {

    private final AddressRepository addressRepository;

    public CreateAddressUseCaseImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void create(Address address) {
        addressRepository.create(address);
    }
}
