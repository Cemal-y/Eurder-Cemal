package com.cml.eurder.domain.user;

import java.util.UUID;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phoneNumber;
    private Role role;

    public User(UserBuilder userBuilder) {
        this.id = UUID.randomUUID().toString();
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
        this.address = userBuilder.address;
        this.phoneNumber = userBuilder.phoneNumber;
        this.role = userBuilder.role;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private Address address;
        private String phoneNumber;
        public Role role;

        private UserBuilder() {
        }

        public static UserBuilder userBuilder() {
            return new UserBuilder();
        }
        public User build() {
            return new User(this);
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }
        public UserBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }
        public UserBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public UserBuilder withRole(Role role) {
            this.role = role;
            return this;
        }
    }

}
