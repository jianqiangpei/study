package api.study.pjq.client.order;


import api.study.pjq.config.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "study-order")
public interface IOrderClient {





}
