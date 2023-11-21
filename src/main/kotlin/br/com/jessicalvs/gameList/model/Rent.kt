package br.com.jessicalvs.gameList.model

import java.time.LocalDate
import java.time.Period
import kotlin.time.times

data class Rent (
    val gamer : Gamer,
    val game : Game,
    val period : PeriodRental){

    val rentPrice = game.price * period.inDays


    override fun toString(): String {
        return "Rent of the game ${game.title} por ${gamer.name} pelo valor de R$ ${rentPrice}"
    }
}