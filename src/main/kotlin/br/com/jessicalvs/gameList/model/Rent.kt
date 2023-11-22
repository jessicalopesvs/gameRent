package br.com.jessicalvs.gameList.model

import java.time.LocalDate
import java.time.Period
import kotlin.time.times

data class Rent (
    val gamer : Gamer,
    val game : Game,
    val period : PeriodRental){

    val rentPrice = gamer.subscription.getRentValue(this)
    var id : String? = null



    override fun toString(): String {
        return "Game: ${game.title}\n Gamer: ${gamer.name}  \n Rent Price: R$ ${rentPrice} \n Date: ${period.date}"
    }
}
//return "Rent of the game ${game.title} por ${gamer.name} pelo valor de R$ ${rentPrice}"
