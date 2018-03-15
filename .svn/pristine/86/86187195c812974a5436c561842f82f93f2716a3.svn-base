package com.hgicreate.rno.service;

import com.hgicreate.rno.domain.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by chao.xj on 2017/6/1.
 */
public interface UserServiceTest {

    UserInfo findByName(String name);

    UserInfo findByNameAndAge(String name, Integer age);

    @Query("from UserInfo u where u.name =:name")
    UserInfo findUser(@Param("name") String name);
}
