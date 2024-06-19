package com.web.service.repository;

import com.web.service.entites.User;
import com.web.service.service.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User save(UserDto userDto);
}