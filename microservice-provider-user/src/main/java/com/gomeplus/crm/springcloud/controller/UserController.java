package com.gomeplus.crm.springcloud.controller;

import com.gomeplus.crm.springcloud.dao.UserRepository;
import com.gomeplus.crm.springcloud.entity.User;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作用：
 * 1.测试服务的相关实例
 * 2.为后来的服务做提供
 * Created by baixiangzhu on 2017/1/23.
 */
@RestController
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserRepository userRepository;

    /**
     * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
     * @RequestMapping(value = "/id", method = RequestMethod.GET)
     * 类似的注解还有@PostMapping等等
     * @param id
     * @return user信息
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){

        User user = this.userRepository.findOne(id);

        return user;
    }


    /**
     * 本地服务实例的信息
     * @return
     */
    @GetMapping("/instance-info")
    public ServiceInstance showInfo(){

        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();

        return localServiceInstance;

    }


}
