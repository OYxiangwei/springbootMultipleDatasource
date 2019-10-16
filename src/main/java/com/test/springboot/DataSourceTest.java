package com.test.springboot;

import com.test.springboot.first.UserOne;
import com.test.springboot.first.UserOneService;
import com.test.springboot.second.UserTwo;
import com.test.springboot.second.UserTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSourceTest implements ApplicationRunner {
    @Autowired
    public UserTwoService userTwoService;
    @Autowired
    public UserOneService userOneService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserOne userOne = new UserOne();
        userOne.setUsername("oy");
        userOne.setPassword("123");
        userOneService.save(userOne);
        UserTwo userTwo = new UserTwo();
        userTwo.setUsername("hacker");
        userTwo.setPassword("110");
        userTwoService.save(userTwo);
    }
}
