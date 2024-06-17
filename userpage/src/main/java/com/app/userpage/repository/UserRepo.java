package com.app.userpage.repository;

import com.app.userpage.entites.User;
import com.app.userpage.service.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User save(UserDto userDto);
}