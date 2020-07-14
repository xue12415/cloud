package com.example.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xue
 * @date 2020-05-28 15:35
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced//ribbon实现负载均衡，是实现客户端的负载均衡，是一个软负载均衡的客户端组建
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * 不添加自定义负载均衡规则，使用上面的LoadBalanced（轮询）
     * 优先调用自定义的负载均衡规则
     * @return
     */
    @Bean
    public IRule myRule(){
        //turn new RandomRule();//随机机调用
        return new RetryRule();//如果2号宕机，则在尝试几次失败后，则不再调用2号机
    }
}
