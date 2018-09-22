package api.study.pjq.client.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 用户微服务
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION , value = ExcludeFromComponentScan.class))
//@ComponentScan
//@RibbonClient(name = "study-user" , configuration = RibbonRuleConfiguration.class)
public class StudyUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyUserApplication.class , args);
    }
}
