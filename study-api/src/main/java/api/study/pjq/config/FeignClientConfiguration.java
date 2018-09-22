package api.study.pjq.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients(basePackages = {"api.study.pjq.client"})
public class FeignClientConfiguration {
}
