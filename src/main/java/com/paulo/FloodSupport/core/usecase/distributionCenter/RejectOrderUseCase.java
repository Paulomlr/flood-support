package com.paulo.FloodSupport.core.usecase.distributionCenter;

import com.paulo.FloodSupport.core.domain.Order;

public interface RejectOrderUseCase {

    void rejectOrder(Order order);
}
