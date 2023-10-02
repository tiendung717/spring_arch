package com.solid.backend.users.userservice.service;

import com.solid.backend.users.userservice.shared.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDetails);
}
