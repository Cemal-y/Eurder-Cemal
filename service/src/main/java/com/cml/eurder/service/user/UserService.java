package com.cml.eurder.service.user;

import com.cml.eurder.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Collection<UserDto> getAllUsersInTheDataBase() {
        return userMapper.toDto(userRepository.getAllUsers());
    }

    public UserDto registerUser(UserDto userDto){
        return userMapper.toDto(userRepository.addUser(userMapper.toUser(userDto)));
    }
}
