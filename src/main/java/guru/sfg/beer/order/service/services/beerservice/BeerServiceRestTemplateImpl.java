package guru.sfg.beer.order.service.services.beerservice;

import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BeerServiceRestTemplateImpl implements BeerService {
    private final String BEER_SERVICE_PATH = "/api/v1/beerUpc/";

    private String beerServiceHost;

    private final RestTemplate restTemplate;

    public BeerServiceRestTemplateImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public void setBeerServiceHost(String beerServiceHost) {
        this.beerServiceHost = beerServiceHost;
    }

    @Override
    public Optional<BeerDto> getBeerDetailsByUpc(String upc){
        return Optional.of(restTemplate.getForObject(beerServiceHost + BEER_SERVICE_PATH + upc,BeerDto.class));
    }

}
