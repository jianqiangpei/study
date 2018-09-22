package api.study.pjq.client.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 开启负载均衡
 */
@Configuration
public class RestTemplateConfig {

    /**
     * @LoadBalanced 让RestTemplate拥有负载均衡的能力
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){

//        如果只是使用ribbon，使用http访问测试超时时间，需要在这里配置，在配置文件中配置不好使
//        HttpComponentsClientHttpRequestFactory httpRequestFactory =  new HttpComponentsClientHttpRequestFactory();
//        httpRequestFactory.setReadTimeout(5000);
//        httpRequestFactory.setConnectTimeout(5000);
//        return new RestTemplate(httpRequestFactory);

        return new RestTemplate();
    }


}
