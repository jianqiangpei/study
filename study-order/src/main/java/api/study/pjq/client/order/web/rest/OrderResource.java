package api.study.pjq.client.order.web.rest;

import api.study.pjq.core.entity.StudyResponseEntity;
import api.study.pjq.client.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 订单资源
 * Hystrix 只能在被@service 或者 @comment 修饰的类中使用
 *
 *
 */
//@EnableCircuitBreaker
@RestController
@RequestMapping("/api/order")
public class OrderResource {

    @Autowired
    private IOrderService orderService;


    @GetMapping(value = "/getOrderId")
    public StudyResponseEntity getOrderId(){

        String orderId = orderService.getOrderId(UUID.randomUUID().toString());

        return StudyResponseEntity.ok(orderId);
    }





}
