package guru.sfg.beer.order.service.services.beerservice;

import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;

import java.util.Optional;

public interface BeerService {
    Optional<BeerDto> getBeerDetailsByUpc(String upc);
}
