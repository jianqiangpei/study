package api.study.pjq.client.user.web.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 用户资源
 */
@RestController
@RequestMapping("/api/user")
public class UserResource {


    @GetMapping(value = "/getUser" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getUser(){

        System.out.println("我是1");
        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是2");

        return "1";
    }

}
