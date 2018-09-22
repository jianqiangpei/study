package api.study.pjq.client.order.config;

import com.netflix.loadbalancer.*;

/**
 * ribbon 负载均衡规则
 */
//@Configuration
//@ExcludeFromComponentScan
public class RibbonRuleConfiguration {

//    @Bean
    public IRule ribbonRule() {

        IRule rule;

        /**
         * 随机策略
         * 每次利用random对象生成一个不大于服务实例总数的随机数，并将该数作为下标所以获取一个服务实例。
         */
//        rule = new RandomRule();

        /**
         * 轮询策略
         * 开启一个计数器count，在while循环中遍历服务清单，获取清单之前先通过incrementAndGetModulo方法获取一个下标
         * ，这个下标是一个不断自增长的数先加1然后和服务清单总数取模之后获取到的（所以这个下标从来不会越界），拿着下标再去服务
         * 清单列表中取服务，每次循环计数器都会加1，如果连续10次都没有取到服务，则会报一个警告No available alive servers
         * after 10 tries from load balancer: XXXX。
         */
        rule = new RoundRobinRule();

        /**
         * 负载均衡策略带有重试功能
         * 首先RetryRule中又定义了一个subRule，它的实现类是RoundRobinRule，然后在RetryRule的choose(ILoadBalancer lb, Object key)方法中，
         * 每次还是采用RoundRobinRule中的choose规则来选择一个服务实例，如果选到的实例正常就返回，如果选择的服务实例为null或者已经失效，
         * 则在失效时间deadline之前不断的进行重试（重试时获取服务的策略还是RoundRobinRule中定义的策略），如果超过了deadline还是没取到
         * 则会返回一个null。
         */
//        rule = new RetryRule();

        /**
         * 权重策略
         * WeightedResponseTimeRule是RoundRobinRule的一个子类，在WeightedResponseTimeRule中对RoundRobinRule的功能进行了扩展，
         * WeightedResponseTimeRule中会根据每一个实例的运行情况来给计算出该实例的一个权重，然后在挑选实例的时候则根据权重进行挑选，
         * 这样能够实现更优的实例调用。WeightedResponseTimeRule中有一个名叫DynamicServerWeightTask的定时任务，默认情况下每隔30秒
         * 会计算一次各个服务实例的权重，权重的计算规则也很简单，如果一个服务的平均响应时间越短则权重越大，那么该服务实例被选中执行任务
         * 的概率也就越大。
         */
//        rule = new WeightedResponseTimeRule();

        /**
         * 与 RoundRobinRule 策略一致
         */
//        rule = new ClientConfigEnabledRoundRobinRule();

        /**
         * 最好策略，过滤掉失效的服务，并且找出并发最小的服务实例来使用
         * BestAvailableRule继承自ClientConfigEnabledRoundRobinRule，它在ClientConfigEnabledRoundRobinRule的基础上主要增加
         * 了根据loadBalancerStats中保存的服务实例的状态信息来过滤掉失效的服务实例的功能，然后顺便找出并发请求最小的服务实例来使用。
         * 然而loadBalancerStats有可能为null，如果loadBalancerStats为null，则BestAvailableRule将采用它的父类即ClientConfigEnabledRoundRobinRule的服务选取策略（线性轮询）。
         */
//        rule = new BestAvailableRule();


        return rule;

    }


}
