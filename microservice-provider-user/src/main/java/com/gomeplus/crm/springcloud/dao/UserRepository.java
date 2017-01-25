package com.gomeplus.crm.springcloud.dao;

import com.gomeplus.crm.springcloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by baixiangzhu on 2017/1/23.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
