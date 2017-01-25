package com.gomeplus.crm.springcloud.entity;

/**
 * Created by baixiangzhu on 2017/1/24.
 */
public class User {

    private Long id;
    private String username;
    private Integer age;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
