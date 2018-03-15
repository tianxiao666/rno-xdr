package com.hgicreate.rno.service;

import com.hgicreate.rno.domain.UserInfo;
import com.hgicreate.rno.repository.UserTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chao.xj on 2017/6/1.
 */
@Service
public class UserServiceImpl implements UserServiceTest {

    @Autowired
    UserTestRepository userRepository;

    @Override
    public UserInfo findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public UserInfo findByNameAndAge(String name, Integer age) {
        return userRepository.findByNameAndAge(name,age);
    }

    @Override
    public UserInfo findUser(String name) {
        return userRepository.findUser(name);
    }
}
