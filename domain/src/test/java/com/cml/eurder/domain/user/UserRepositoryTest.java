package com.cml.eurder.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.cml.eurder.domain.user.Role.CUSTOMER;
import static com.cml.eurder.domain.user.User.UserBuilder.userBuilder;

class UserRepositoryTest {
    UserRepository userRepository = new UserRepository();
    User customer1 = userBuilder().withRole(CUSTOMER).build();

    @Test
    void checkIfCustomerIsAdded(){
        userRepository.addUser(customer1);
        Assertions.assertTrue(userRepository.getUserDatabase().containsKey(customer1.getId()));
    }

}