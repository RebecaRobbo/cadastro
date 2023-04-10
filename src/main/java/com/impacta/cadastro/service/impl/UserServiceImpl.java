package com.impacta.cadastro.service.impl;

import com.impacta.cadastro.dto.UserDTO;
import com.impacta.cadastro.entity.User;
import com.impacta.cadastro.repository.UserRepository;
import com.impacta.cadastro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public User createUser(User user) {
        User userByEmail = userRepository.findUserByEmail(user.getEmail());
        if (Objects.isNull(userByEmail)) {
            return userRepository.save(user); //savando no banco o usuario
        }
        return null;
    }

    @Override
    public Boolean findUser(UserDTO userDTO) {
        final User resultUser = userRepository.findUserByEmail(userDTO.getEmail());
        if (Objects.nonNull(resultUser)) {
            return resultUser.getPassword().equals(userDTO.getPassword())? Boolean.TRUE : Boolean.FALSE;
        }
        return false;
    }
}
