package com.impacta.cadastro.controller;

import com.impacta.cadastro.dto.UserDTO;
import com.impacta.cadastro.entity.User;
import com.impacta.cadastro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/api") //caminho
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody @Validated User user) {
        User userCreated = userService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean validateLogin(@RequestBody @Validated UserDTO userDTO) {
        return userService.findUser(userDTO);
    }

}
