package com.solid.backend.users.userservice.controllers;

import com.solid.backend.users.userservice.model.CreateUserRequestModel;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/status/check")
    public String status() {
        return "Working";
    }

    @PostMapping
    public String createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
        return "Create user method is called";
    }
}
