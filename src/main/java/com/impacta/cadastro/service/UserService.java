package com.impacta.cadastro.service;

import com.impacta.cadastro.dto.UserDTO;
import com.impacta.cadastro.entity.User;

public interface UserService {

    User createUser(User user);

    Boolean findUser(UserDTO userDTO);
}
