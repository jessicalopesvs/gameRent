package br.com.jessicalvs.gameList.principal

import br.com.jessicalvs.gameList.data.DatabaseConection
import br.com.jessicalvs.gameList.data.SubscriptionDAO
import br.com.jessicalvs.gameList.model.Subscription
import br.com.jessicalvs.gameList.model.SubscriptionFree
import br.com.jessicalvs.gameList.model.SubscriptionPaid
import javax.persistence.EntityManager

fun main() {
    val entityManager: EntityManager = DatabaseConection.getEntityManager()

    val subscriptionDao = SubscriptionDAO(entityManager)

    // Creating a SubscriptionFree object
    val subscriptionFree = SubscriptionFree("Free", 1)
    subscriptionDao.add(subscriptionFree)

    // Creating a SubscriptionPaid object
    val subscriptionPaid = SubscriptionPaid("Paid", 10.0, 5, 0.2, 2)
    subscriptionDao.add(subscriptionPaid)

    // Retrieving subscriptions from the database
    val retrievedSubscription = subscriptionDao.getList()

    // Printing the retrieved subscriptions
    println(subscriptionDao.getList())

}