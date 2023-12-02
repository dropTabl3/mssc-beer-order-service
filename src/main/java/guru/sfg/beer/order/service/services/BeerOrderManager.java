package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.domain.BeerOrder;
import guru.sfg.beer.order.service.web.model.BeerOrderDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by jt on 11/29/19.
 */
public interface BeerOrderManager {

    BeerOrder newBeerOrder(BeerOrder beerOrder);

    void validateOrder(UUID orderId, boolean valid);

    void beerOrderAllocationPassed(BeerOrderDto beerOrderDto);

    void beerOrderAllocationPendingInventory(BeerOrderDto beerOrderDto);

    void beerOrderAllocationFailed(BeerOrderDto beerOrderDto);
}
