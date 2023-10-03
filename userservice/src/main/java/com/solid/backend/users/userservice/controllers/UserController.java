package com.solid.backend.users.userservice.controllers;

import com.solid.backend.users.userservice.model.CreateUserRequestModel;
import com.solid.backend.users.userservice.model.CreateUserResponseModel;
import com.solid.backend.users.userservice.service.UserService;
import com.solid.backend.users.userservice.shared.UserDto;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/status/check")
    public String status() {
        return "Working";
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        UserDto createdUserDto = userService.createUser(userDto);
        CreateUserResponseModel returnValue = modelMapper.map(createdUserDto, CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}
