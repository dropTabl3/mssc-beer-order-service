package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;

public interface BeerService {
    BeerDto getBeerDetailsBy(String upc);
}
