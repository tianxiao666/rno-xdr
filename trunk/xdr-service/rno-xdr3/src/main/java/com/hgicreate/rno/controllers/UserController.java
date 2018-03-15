package com.hgicreate.rno.controllers;

import com.hgicreate.rno.domain.UserInfo;
import com.hgicreate.rno.service.UserServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chao.xj on 2017/6/1.
 */
@RestController
public class UserController {

    @Autowired
    UserServiceTest userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/index1")
    String index(@RequestParam("name") String name){
        System.out.println("name=="+name);
        logger.debug("name={}",name);
      UserInfo userInfo = userService.findByName(name);
      logger.debug("userInfo={}",userInfo);
      System.out.println("userInfo==="+userInfo);
      return  userInfo.toString();
    }
}
