package com.ypzhang

class Account {
    Integer accountType
    String accountNumber

    static mapping = {
        version(false)
        id:'identity'
    }
    static belongsTo = [customer:Customer]
}
