package com.ypzhang

import grails.gorm.services.Service

@Service(Mortgage)
interface MortgageService {

    Mortgage get(Serializable id)

    List<Mortgage> list(Map args)

    Long count()

    void delete(Serializable id)

    Mortgage save(Mortgage mortgage)

}