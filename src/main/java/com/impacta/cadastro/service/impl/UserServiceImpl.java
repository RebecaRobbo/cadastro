package com.impacta.cadastro.service.impl;

import com.impacta.cadastro.entity.User;
import com.impacta.cadastro.repository.UserRepository;
import com.impacta.cadastro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //@Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user); //savando no banco o usuario
    }
}
