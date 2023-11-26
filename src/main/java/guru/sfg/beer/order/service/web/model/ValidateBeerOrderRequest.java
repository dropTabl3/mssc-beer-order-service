package guru.sfg.beer.order.service.web.model;

import guru.sfg.beer.order.service.web.model.BeerOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidateBeerOrderRequest {
    private BeerOrderDto beerOrderDto;
}
