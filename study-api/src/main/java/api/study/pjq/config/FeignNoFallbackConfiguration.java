package api.study.pjq.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class FeignNoFallbackConfiguration {

    @Bean
    @Primary
    public Feign.Builder feignBuilder(){

        return new Feign.Builder();
    }

}
