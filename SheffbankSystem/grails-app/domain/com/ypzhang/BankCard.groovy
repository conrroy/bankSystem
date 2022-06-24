package com.ypzhang

class BankCard {
    String cardNumber
    Integer cardType
    Date expirationDate
    static mapping = {
        version(false)
        id:'identity'
    }
    static belongsTo = [account: Account]
}
