package com.ypzhang

import grails.gorm.services.Service

@Service(BankCard)
interface BankCardService {

    BankCard get(Serializable id)

    List<BankCard> list(Map args)

    Long count()

    void delete(Serializable id)

    BankCard save(BankCard bankCard)

}