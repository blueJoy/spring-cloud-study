package com.gomeplus.crm.springcloud.client;

import com.gomeplus.crm.springcloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用@FeignClient("microservice-provider-user")注解绑定microservice-provider-user服务，还可以使用url参数指定一个URL。
 * Created by baixiangzhu on 2017/1/24.
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping("/{id}")
    User fineUserByIdFeign(@RequestParam("id") Long id);

}
