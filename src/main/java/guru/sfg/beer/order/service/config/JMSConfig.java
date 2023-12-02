package guru.sfg.beer.order.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JMSConfig {

    public static final String VALIDATE_ORDER_Q = "validate-order";
    public static final String VALIDATE_ORDER_RESULT_Q = "validate-order-result";
    public static final String ALLOCATE_ORDER_Q = "allocate-order-q";
    public static final String ALLOCATE_ORDER_RESULT_Q = "allocate-order-result";


    @Bean
    public MessageConverter messageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
