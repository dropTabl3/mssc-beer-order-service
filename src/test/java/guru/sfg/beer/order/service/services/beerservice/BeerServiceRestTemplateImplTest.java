package guru.sfg.beer.order.service.services.beerservice;

import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Disabled
@SpringBootTest
class BeerServiceRestTemplateImplTest {

    @Autowired
    BeerService beerService;
    @Test
    void getBeerDetailsBy() {
        Optional<BeerDto> beerDetailsByUpc = beerService.getBeerDetailsByUpc("0631234200036");
        System.out.println(beerDetailsByUpc.get());
    }
}