package com.cml.eurder.service.item;

import com.cml.eurder.domain.user.User;
import com.cml.eurder.service.user.UserDto;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    public Collection<UserDto> toDto(Collection<User> userCollection) {
        return userCollection.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getAddress()
                ,user.getPhoneNumber(), user.getRole());
    }

    public User toUser(UserDto userDto) {
        return User.UserBuilder.userBuilder()
                .withRole(userDto.getRole())
                .withAddress(userDto.getAddress())
                .withEmail(userDto.getEmail())
                .withFirstName(userDto.getFirstName())
                .withLastName(userDto.getLastName())
                .withPhoneNumber(userDto.getPhoneNumber())
                .build();
    }
}
