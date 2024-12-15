package com.paulo.FloodSupport.core.usecase.distributionCenter;

import com.paulo.FloodSupport.core.domain.Order;

public interface ProcessOrderReceivedUseCase {

    void processOrder(Order order);
}
