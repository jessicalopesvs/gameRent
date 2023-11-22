package br.com.jessicalvs.gameList.data

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object DatabaseConection {

//    fun getConection(): Connection? {
//        return try {
//            DriverManager.getConnection("jdbc:mysql://localhost:3306/gameRent", "root", "monica24")
//        } catch (e: SQLException) {
//            e.printStackTrace()
//            null
//        }
//    }

    fun getEntityManager () : EntityManager{
        val factory : EntityManagerFactory = Persistence.createEntityManagerFactory("gameRent")
        return factory.createEntityManager()
    }

}