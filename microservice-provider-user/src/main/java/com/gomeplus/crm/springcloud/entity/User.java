package com.gomeplus.crm.springcloud.entity;

import javax.persistence.*;

/**
 * Created by baixiangzhu on 2017/1/23.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private Integer age;


    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
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
