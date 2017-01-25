package com.gomeplus.crm.springcloud.service;

import com.gomeplus.crm.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by baixiangzhu on 2017/1/24.
 */
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public User findUserById(Long id){

        return this.restTemplate.getForObject("http://microservice-provider-user/"+id,User.class);
    }

}
