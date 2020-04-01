package com.cml.eurder.domain.user;

import com.cml.eurder.domain.exceptions.InputCanNotBeNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.cml.eurder.domain.user.Address.AddressBuilder.addressBuilder;
import static com.cml.eurder.domain.user.Role.CUSTOMER;
import static com.cml.eurder.domain.user.User.UserBuilder.userBuilder;

@Repository
public class UserRepository {
    ConcurrentHashMap<String, User> userDatabase;

    public UserRepository() {
        userDatabase = new ConcurrentHashMap<>();
        createDefaultData();
    }

    public User addUser(User user){
        checkIfInputNull(user);
        userDatabase.put(user.getId(), user);
        return user;
    }

    public Collection<User> getAllUsers(){
        return userDatabase.values()
                .stream().collect(Collectors.toList());
    }

    public ConcurrentHashMap<String, User> getUserDatabase() {
        return userDatabase;
    }

    public static <T> void checkIfInputNull(T input) {
        if (input == null) {
            throw new InputCanNotBeNullException();
        }
    }

    private void createDefaultData(){
        User user1 = userBuilder()
                .withFirstName("John")
                .withLastName("Doe")
                .withPhoneNumber("5464646565")
                .withEmail("jqskld@fsqfqdfs.com")
                .withAddress(addressBuilder().withCity("Brussel").withStreet("abc").build())
                .withRole(CUSTOMER).build();

        userDatabase.put(user1.getId(), user1);
    }
}
