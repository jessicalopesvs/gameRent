package br.com.jessicalvs.gameList.data

import br.com.jessicalvs.gameList.model.Game
import javax.persistence.EntityManager
import javax.persistence.EntityTransaction

//GENERIC
//DAO data access object
abstract class DAO<T, Entity>(protected val manager: EntityManager, val entityType: Class<Entity>) {
    abstract fun toEntity(obj: T): Entity
    abstract fun toModel(entity: Entity): T
    open fun getList(): List<T> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map { entity ->
            toModel(entity)

        }
    }

    //template method
    open fun add(obj: T) {
        val entity = toEntity(obj)
        val transaction = manager.transaction
        try {
            transaction.begin()
            manager.persist(entity)
            transaction.commit()
        } catch (e: Exception) {
            if (transaction.isActive) {
                transaction.rollback()
            }
            throw e
        }
    }

    open fun getById(id: Int): T {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id",id)
        val entity = query.singleResult
        return toModel(entity)
    }

    open fun deleteById (id : Int){
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id",id)
        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }
}
