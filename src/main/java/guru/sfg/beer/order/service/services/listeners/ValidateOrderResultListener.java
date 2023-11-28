package guru.sfg.beer.order.service.services.listeners;

import guru.sfg.beer.order.service.config.JMSConfig;
import guru.sfg.beer.order.service.services.BeerOrderManager;
import guru.sfg.common.events.ValidateBeerOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class ValidateOrderResultListener {

    private final BeerOrderManager beerOrderManager;
    @JmsListener(destination = JMSConfig.VALIDATE_ORDER_RESULT_Q)
    public void listen(ValidateBeerOrderResponse response) {
        beerOrderManager.validateOrder(response.getOrderId(), response.isValid());
    }
}
