package com.ypzhang

class Loan {
    Integer loanType
    Boolean monthlyPayment
    Float amount
    Integer repaymentPeriod
    static belongsTo = [customer: Customer]
    static mapping = {
        version(false)
        id:'identity'
    }
    static constraints = {
        customer (unique: true)
    }
}
