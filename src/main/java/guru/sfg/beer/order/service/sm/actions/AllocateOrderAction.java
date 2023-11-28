package guru.sfg.beer.order.service.sm.actions;

import guru.sfg.beer.order.service.config.JMSConfig;
import guru.sfg.beer.order.service.domain.BeerOrder;
import guru.sfg.beer.order.service.domain.BeerOrderEventEnum;
import guru.sfg.beer.order.service.domain.BeerOrderStatusEnum;
import guru.sfg.beer.order.service.repositories.BeerOrderRepository;
import guru.sfg.beer.order.service.services.BeerOrderManagerImpl;
import guru.sfg.beer.order.service.web.mappers.BeerOrderMapper;
import guru.sfg.common.events.AllocateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AllocateOrderAction implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {
    private final JmsTemplate jmsTemplate;
    private final BeerOrderRepository beerOrderRepository;
    private final BeerOrderMapper beerOrderMapper;
    @Override
    public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> stateContext) {
        UUID orderId = UUID.class.cast(stateContext.getMessage().getHeaders().get(BeerOrderManagerImpl.ORDER_ID_HEADER));
        BeerOrder order = beerOrderRepository.getOne(orderId);
        AllocateOrderRequest req = AllocateOrderRequest.builder()
                .beerOrderDto(beerOrderMapper.beerOrderToDto(order))
                .build();
        jmsTemplate.convertAndSend(JMSConfig.ALLOCATE_ORDER_Q, req);
    }
}
