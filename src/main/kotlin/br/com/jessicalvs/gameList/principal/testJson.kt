package br.com.jessicalvs.gameList.principal

import br.com.jessicalvs.gameList.model.Gamer
import br.com.jessicalvs.gameList.model.PeriodRental
import br.com.jessicalvs.gameList.services.APIcall
import java.time.LocalDate

fun main() {
    val apiCall = APIcall()
    val listGamers = apiCall.searchGamer()
    val listGame = apiCall.searchGame()


    val gamerCaroline = listGamers.get(3)
    val gameRED = listGame.get(10)

   val period = PeriodRental(LocalDate.now(), LocalDate.now().plusDays(7))

    val rent = gamerCaroline.rentGame(gameRED, period)
    println("Rent Alert: " + rent)
}