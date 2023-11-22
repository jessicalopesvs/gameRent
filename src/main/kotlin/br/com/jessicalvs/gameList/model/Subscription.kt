package br.com.jessicalvs.gameList.model

abstract class Subscription (val type : String) {
    open var id : Int? = null

    open fun getRentValue (rent: Rent) : Double{
        return   rent.game.price * rent.period.inDays
    }
}