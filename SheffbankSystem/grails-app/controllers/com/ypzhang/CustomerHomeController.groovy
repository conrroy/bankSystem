package com.ypzhang

class CustomerHomeController {
    def index(Long id) {
        // List loanList = Loan.findAllWhere(customer_id: id)
        def user = Customer.findById(id)
        def loanList = user ? Loan.findAllByCustomer(user) : []
        def mortgageList = user ? Mortgage.findAllByCustomer(user): []

        respond loanList, view:'/customer'
        respond mortgageList, view:'/customer'
        return
    }
}
