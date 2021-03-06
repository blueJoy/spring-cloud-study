package com.gomeplus.crm.springcloud.service;

import com.gomeplus.crm.springcloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by baixiangzhu on 2017/1/24.
 */
@Service
public class RibbonHystrixService {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RibbonHystrixService.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     * @param id id
     * @return 通过id查询到的用户
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public User findById(Long id){

        return this.restTemplate.getForObject("http://microservice-provider-user/" + id,User.class);
    }


    /**
     * hystrix fallback方法
     * @param id id
     * @return 默认的用户
     */
    public User fallback(Long id){

        RibbonHystrixService.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
        User user = new User();
        user.setId(-1L);
        user.setUsername("default username");
        user.setAge(0);
        return user;
    }

}
