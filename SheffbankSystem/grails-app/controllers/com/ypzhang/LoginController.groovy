package com.ypzhang

import grails.converters.JSON

class LoginController {
    def signIn() {
        def customer = Customer.findByName(request.getParameter("username"))
        if (customer) {
            if (customer.password == request.getParameter("password")) {
                session.setAttribute("role", customer.role)
                session.setAttribute("id", customer.id)
                // response.status = 200
                render customer as JSON
            } else {
                response.status = 401
                return 'error'
            }
        } else {
            response.status = 401
            return 'error'
        }
        // def customer = Customer.findByName("jack")


    }
}
