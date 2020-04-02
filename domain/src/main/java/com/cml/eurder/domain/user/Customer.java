package com.cml.eurder.domain.user;

public class Customer extends User {

//    public Customer(Builder userBuilder) {
//        super(userBuilder);
//    }
    protected Customer(Builder<?> builder) {
        super(builder);
    }


    public static abstract class Builder<T extends Customer> extends User.Builder<T> {

        public static Builder<?> customerBuilder() {
            return new Builder<Customer>()
            {
                @Override
                public Customer build()
                {
                    return new Customer(this);
                }
            };
        }


//
//        public Builder() {
//        }
//
//        public static Builder customerBuilder() {
//            return new Builder();
//        }
//
//        public Customer build() {
//            return new Customer(this);
//        }

    }

}
