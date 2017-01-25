package com.gomeplus.crm.springcloud.controller;

import com.gomeplus.crm.springcloud.entity.User;
import com.gomeplus.crm.springcloud.service.RibbonHystrixService;
import com.gomeplus.crm.springcloud.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by baixiangzhu on 2017/1/24.
 */
@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @Autowired
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("/ribbon/{id}")
    public User findById(@PathVariable Long id){

        return ribbonService.findUserById(id);
    }

    @GetMapping("/ribbon/hystrix/{id}")
    public User findByIdHystrix(@PathVariable Long id){

        return ribbonHystrixService.findById(id);
    }
}
