package com.ypzhang

class Customer {
    String name
    String address
    String emailAddress
    static hasMany = [accounts: Account]
    static hasOne = [loan: Loan, mortage: Mortgage]
    static mapping = {
        version(false)
        id:'identity'
    }
}
