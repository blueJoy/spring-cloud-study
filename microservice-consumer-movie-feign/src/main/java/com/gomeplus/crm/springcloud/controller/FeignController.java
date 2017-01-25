package com.gomeplus.crm.springcloud.controller;

import com.gomeplus.crm.springcloud.client.UserFeignClient;
import com.gomeplus.crm.springcloud.client.UserFeignHystrixClient;
import com.gomeplus.crm.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by baixiangzhu on 2017/1/24.
 */
@RestController
public class FeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("feign/{id}")
    public User findByIdFeign(@PathVariable Long id){

        return this.userFeignClient.fineUserByIdFeign(id);

    }

    @GetMapping("feign/hystrix/{id}")
    public User findByIdFeignHystrix(@PathVariable Long id){

        return this.userFeignHystrixClient.findByIdFeign(id);

    }

}
