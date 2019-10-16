package com.test.springboot.second;

import com.test.springboot.first.UserOne;
import com.test.springboot.first.UserOneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserTwoService {
    @Autowired
    private UserTwoRepository userTwoRepository;
    @Transactional(rollbackFor = Exception.class)
    public UserTwo save(UserTwo userTwo){
        return userTwoRepository.save(userTwo);
    }
}
