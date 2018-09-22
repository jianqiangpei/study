package api.study.pjq.fallback.user;

import api.study.pjq.client.user.IUserClient;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements IUserClient{

    @Override
    public String getUser() {

        return "断路了";
    }
}
