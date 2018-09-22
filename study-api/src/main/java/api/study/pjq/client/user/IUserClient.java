package api.study.pjq.client.user;

import api.study.pjq.fallback.user.UserClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "study-user" , fallback = UserClientFallback.class)
public interface IUserClient {

    @GetMapping(value = "/api/user/getUser")
    String getUser();

}
