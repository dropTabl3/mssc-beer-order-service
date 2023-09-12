package guru.sfg.beer.order.service.services.beerservice;

import guru.sfg.beer.order.service.services.BeerService;
import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BeerServiceRestTemplateImpl implements BeerService {
    private final String BEER_SERVICE_PATH = "/api/v1/beerUpc/{upc}";

    private String beerServiceHost;

    private final RestTemplate restTemplate;

    public BeerServiceRestTemplateImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public void setBeerServiceHost(String beerServiceHost) {
        this.beerServiceHost = beerServiceHost;
    }

    @Override
    public BeerDto getBeerDetailsBy(String upc){
        ParameterizedTypeReference<BeerDto> typeReference = new ParameterizedTypeReference<BeerDto>() {
        };

        ResponseEntity<BeerDto> responseEntity = restTemplate
                .exchange(beerServiceHost + BEER_SERVICE_PATH, HttpMethod.GET, null,
                        typeReference, (Object) upc);

        return Objects.requireNonNull(responseEntity.getBody());

    }

}
