package com.ypzhang

class Customer {
    String name
    String address
    String emailAddress
    String password
    Integer role
    static mapping = {
        version(false)
        id:'identity'
    }
}
