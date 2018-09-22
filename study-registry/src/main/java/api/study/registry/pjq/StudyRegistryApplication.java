package api.study.registry.pjq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心启动
 */
@SpringBootApplication
@EnableEurekaServer
public class StudyRegistryApplication {


    public static void main(String[] args) {
        SpringApplication.run(StudyRegistryApplication.class , args);
    }

}
