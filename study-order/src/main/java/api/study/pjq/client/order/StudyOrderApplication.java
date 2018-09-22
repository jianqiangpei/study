package api.study.pjq.client.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by alex on 2018/6/10.
 */
@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION , value = ExcludeFromComponentScan.class)})
public class StudyOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyOrderApplication.class , args);
    }

}
