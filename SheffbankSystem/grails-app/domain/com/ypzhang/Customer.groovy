package com.ypzhang

class Customer {
    String name
    String address
    String emailAddress
    static mapping = {
        version(false)
        id:'identity'
    }
}
