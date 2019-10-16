package com.test.springboot.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserOneService {
    @Autowired
    private UserOneRepository userOneRepository;
    @Transactional(rollbackFor = Exception.class)
    public UserOne save(UserOne userOne){
        return userOneRepository.save(userOne);
    }
}
