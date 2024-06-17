package com.app.userpage.service;


import com.app.userpage.entites.User;

public interface UserService {
    User findByUsername(String username);

    User save(UserDto userDto);

}