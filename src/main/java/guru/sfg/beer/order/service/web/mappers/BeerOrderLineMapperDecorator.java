package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.services.beerservice.BeerService;
import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public abstract class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {

    @Autowired
    private BeerService beerService;

    @Autowired
    private BeerOrderLineMapper beerOrderMapper;

    @Override
    public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto) {

        Optional<BeerDto> beerDto = beerService.getBeerDetailsByUpc(dto.getUpc());

        beerDto.ifPresent(b->{
            dto.setBeerName(b.getBeerName());
            dto.setBeerId(b.getId());
        });

        return beerOrderMapper.dtoToBeerOrderLine(dto);
    }
}
