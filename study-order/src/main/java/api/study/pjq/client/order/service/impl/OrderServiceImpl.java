package api.study.pjq.client.order.service.impl;

import api.study.pjq.client.order.service.IOrderService;
import api.study.pjq.client.user.IUserClient;
import api.study.pjq.common.util.cache.RedisService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单实现类
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private Logger logger = Logger.getLogger(OrderServiceImpl.class);

    @Resource
    private IUserClient userClient;

    @Resource
    private RedisService redisService;

//    @Autowired
//    private RestTemplate restTemplate;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    int i = 0;

    /**
     * 针对于断路器的配置，注解的配置的优先级>yml文件的配置
     * @param orderId
     * @return
     */
//    @HystrixCommand(fallbackMethod = "backupOrderId",
//        commandProperties = {
//                @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout" , value = "false")
//        }
//    )
    @Override
    public String getOrderId(String orderId) {


        redisService.putString(null , "fuck you , 草泥马的" , 60000L);

        logger.info("=========================="+ ++i+"start=====================================");
        logger.info("request time " + sdf.format(new Date()));

//        ResponseEntity<String> entity = restTemplate.getForEntity("http://study-user/api/user/getUser" , String.class);

//        try {
//            TimeUnit.SECONDS.sleep(8);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        System.out.println(userClient.getUser());

        logger.info("thread status :" + Thread.interrupted());

        logger.info("timeout request " + sdf.format(new Date()) + " , response : ");
        logger.info("==========================end=====================================");


//        throw new NullPointerException("test");

        return "";
    }


    public String backupOrderId(String orderId){

        return "query hystrix , parameter "+ orderId;
    }

}
