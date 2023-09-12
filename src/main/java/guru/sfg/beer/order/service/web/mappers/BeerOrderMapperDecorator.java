package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrder;
import guru.sfg.beer.order.service.services.BeerService;
import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import guru.sfg.beer.order.service.web.model.BeerOrderDto;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BeerOrderMapperDecorator implements BeerOrderMapper {

    @Autowired
    private BeerService beerService;

    @Autowired
    private BeerOrderMapper beerOrderMapper;

    @Override
    public BeerOrder dtoToBeerOrder(BeerOrderDto dto) {
        for(BeerOrderLineDto ol : dto.getBeerOrderLines()) {
            BeerDto beerDetailsBy = beerService.getBeerDetailsBy(ol.getUpc());
            ol.setBeerId(beerDetailsBy.getId());
            ol.setBeerName(beerDetailsBy.getBeerName());
        }
     return beerOrderMapper.dtoToBeerOrder(dto);
    }
}
