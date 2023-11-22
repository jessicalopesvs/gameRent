package br.com.jessicalvs.gameList.principal

import br.com.jessicalvs.gameList.model.PeriodRental
import br.com.jessicalvs.gameList.model.SubscriptionPaid
import br.com.jessicalvs.gameList.services.APIcall
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val apiCall = APIcall()
    val listGamers = apiCall.searchGamer()
    val listGame = apiCall.searchGame()


    val gamerCaroline = listGamers.get(3)
    val gameRED = listGame.get(10)
    val game2 = listGame.get(2)
    val game5 = listGame.get(13)
    val game9 = listGame.get(9)



    val period = PeriodRental(LocalDate.now(), LocalDate.now().plusDays(7))
    val period2 = PeriodRental(LocalDate.now(), LocalDate.now().plusDays(15))
    val period3 = PeriodRental(LocalDate.now(), LocalDate.now().plusDays(30))


    val rent = gamerCaroline.rentGame(gameRED, period)
    val rent2 = gamerCaroline.rentGame(game2, period)
    val rent3 = gamerCaroline.rentGame(game5, period2)
    val rent4 = gamerCaroline.rentGame(game9, period3)

    println(gamerCaroline.rentedGames)


    val gamerCamila = listGamers.get(5)
//    gamerCamila.subscription = SubscriptionPaid("PRATA", 9.90, 0, 0.2, id)
    val rent5 = gamerCamila.rentGame(gameRED, period)
    val rent6 = gamerCamila.rentGame(game2, period2)


    gamerCamila.recomend(8)
    gamerCamila.recomend(8)
    gamerCamila.recomend(10)
    gamerCamila.recomend(10)

    val rental = gamerCamila.rentGame(gameRED, period)


    gamerCamila.recomendGame(gameRED,7)
    gamerCamila.recomendGame(game2, 10)

    gamerCaroline.recomendGame(game2, 6)
    gamerCaroline.recomendGame(gameRED, 3)

//    println("PRINT CAMILAN \n" + gamerCamila.gameRatings)
//    println("PRINT CAROL \n" +gamerCamila.gameRatings)

    val jogoResidentVillage = listGame.get(10)
    val jogoSpider = listGame.get(13)
    val jogoTheLastOfUs = listGame.get(2)
    val jogoDandara = listGame.get(5)
    val jogoAssassins = listGame.get(4)
    val jogoCyber = listGame.get(6)
    val jogoGod = listGame.get(7)
    val jogoSkyrim = listGame.get(18)

    gamerCamila.recomendGame(jogoResidentVillage, 7)
    gamerCamila.recomendGame(jogoTheLastOfUs, 10)
    gamerCamila.recomendGame(jogoAssassins, 8)
    gamerCamila.recomendGame(jogoCyber, 7)
    gamerCamila.recomendGame(jogoGod, 10)
    gamerCamila.recomendGame(jogoDandara, 8)
    gamerCamila.recomendGame(jogoSkyrim, 8)
    gamerCamila.recomendGame(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serialize = gson.toJson(gamerCamila.gameRatings)
//    println(serialize)

    val file = File("gamesRecomends-${gamerCamila.name}.json")
    file.writeText(serialize)
    println(file.absolutePath)


}