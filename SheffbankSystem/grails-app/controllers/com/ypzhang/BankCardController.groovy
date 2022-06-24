package com.ypzhang

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BankCardController {

    BankCardService bankCardService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond bankCardService.list(params), model:[bankCardCount: bankCardService.count()]
    }

    def show(Long id) {
        respond bankCardService.get(id)
    }

    def create() {
        respond new BankCard(params)
    }

    def save(BankCard bankCard) {
        if (bankCard == null) {
            notFound()
            return
        }

        try {
            bankCardService.save(bankCard)
        } catch (ValidationException e) {
            respond bankCard.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bankCard.label', default: 'BankCard'), bankCard.id])
                redirect bankCard
            }
            '*' { respond bankCard, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond bankCardService.get(id)
    }

    def update(BankCard bankCard) {
        if (bankCard == null) {
            notFound()
            return
        }

        try {
            bankCardService.save(bankCard)
        } catch (ValidationException e) {
            respond bankCard.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'bankCard.label', default: 'BankCard'), bankCard.id])
                redirect bankCard
            }
            '*'{ respond bankCard, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        bankCardService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'bankCard.label', default: 'BankCard'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bankCard.label', default: 'BankCard'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
