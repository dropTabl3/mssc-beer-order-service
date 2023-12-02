package guru.sfg.beer.order.service.services.listeners;

import guru.sfg.beer.order.service.config.JMSConfig;
import guru.sfg.beer.order.service.services.BeerOrderManager;
import guru.sfg.common.events.AllocateOrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@RequiredArgsConstructor
public class AllocateOrderResultListener {
    private final BeerOrderManager beerOrderManager;

    @JmsListener(destination = JMSConfig.ALLOCATE_ORDER_RESULT_Q)
    public void listen(AllocateOrderResponse response) {
        if(response.isAllocationError()) {
            beerOrderManager.beerOrderAllocationFailed(response.getBeerOrderDto());
        }
        else if(response.isPendingInventory()) {
            beerOrderManager.beerOrderAllocationPendingInventory(response.getBeerOrderDto());
        }
        else {
            beerOrderManager.beerOrderAllocationPassed(response.getBeerOrderDto());
        }
    }
}
