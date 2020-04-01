package com.cml.eurder.api.endpoints;

import com.cml.eurder.domain.user.UserRepository;
import com.cml.eurder.service.user.UserDto;
import com.cml.eurder.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = UserController.USER_RESOURCE_PATH)
public class UserController {
    public static final String USER_RESOURCE_PATH = "/users";
    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Collection<UserDto> getAllMembers() {
        return userService.getAllUsersInTheDataBase();
    }

    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerAsUser(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }
}
