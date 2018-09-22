package api.study.pjq.config;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"api.study.pjq.fallback"})
public class FeignConfiguration {

    /**
     * 注解翻译器，使用了feign的注解翻译器后，很多springMvc的注解都不起作用了
     */
//    @Bean
//    public Contract feignContract() {
//        return new feign.Contract.Default();
//    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "admin");
    }

    /**
     * 日志记录详细程度级别
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){

        //不记录任何日志
//        return Logger.Level.NONE;

        //只记录请求方法和URL以及响应状态代码h和执行时间
        return Logger.Level.BASIC;

        //记录请求和响应的头的基本信息
//        return Logger.Level.HEADERS;

        //记录请求和响应的头、正文和元数据
//        return Logger.Level.FULL;
    }


}
