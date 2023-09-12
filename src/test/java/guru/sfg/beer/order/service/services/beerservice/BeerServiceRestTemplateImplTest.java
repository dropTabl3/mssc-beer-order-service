package guru.sfg.beer.order.service.services.beerservice;

import guru.sfg.beer.order.service.services.BeerService;
import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
@SpringBootTest
class BeerServiceRestTemplateImplTest {

    @Autowired
    BeerService beerService;
    @Test
    void getBeerDetailsBy() {
        BeerDto beerDetailsByUpc = beerService.getBeerDetailsBy("0631234200036");
        System.out.println(beerDetailsByUpc);
    }
}