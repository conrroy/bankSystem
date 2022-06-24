package com.ypzhang

class Mortgage {
    Integer mortgageType
    Boolean monthlyPayment
    Float totalAmount

    static belongsTo = [customer: Customer]
    static mapping = {
        version(false)
        id:'identity'
    }
    static constraints = {
        customer (unique: true)
    }
}
