package com.paulo.FloodSupport.core.usecase.distributionCenter;

import com.paulo.FloodSupport.core.domain.Order;

public interface AcceptOrderUseCase {

    void acceptOrder(Order order);
}
