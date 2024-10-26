package com.paulo.FloodSupport.application.gateways;

import com.paulo.FloodSupport.core.domain.Address;

public interface AddressRepository {

    Address create(Address address);
}
