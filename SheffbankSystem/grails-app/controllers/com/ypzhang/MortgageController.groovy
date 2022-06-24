package com.ypzhang

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MortgageController {

    MortgageService mortgageService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond mortgageService.list(params), model:[mortgageCount: mortgageService.count()]
    }

    def show(Long id) {
        respond mortgageService.get(id)
    }

    def create() {
        respond new Mortgage(params)
    }

    def save(Mortgage mortgage) {
        if (mortgage == null) {
            notFound()
            return
        }

        try {
            mortgageService.save(mortgage)
        } catch (ValidationException e) {
            respond mortgage.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mortgage.label', default: 'Mortgage'), mortgage.id])
                redirect mortgage
            }
            '*' { respond mortgage, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond mortgageService.get(id)
    }

    def update(Mortgage mortgage) {
        if (mortgage == null) {
            notFound()
            return
        }

        try {
            mortgageService.save(mortgage)
        } catch (ValidationException e) {
            respond mortgage.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mortgage.label', default: 'Mortgage'), mortgage.id])
                redirect mortgage
            }
            '*'{ respond mortgage, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        mortgageService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mortgage.label', default: 'Mortgage'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mortgage.label', default: 'Mortgage'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
