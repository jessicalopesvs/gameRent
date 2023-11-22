package br.com.jessicalvs.gameList.data

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object DatabaseConection {

    fun getEntityManager () : EntityManager{
        val factory : EntityManagerFactory = Persistence.createEntityManagerFactory("gameRent")
        return factory.createEntityManager()
    }

}