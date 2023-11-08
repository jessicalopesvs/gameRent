package br.com.jessicalvs.gameList.principal

import br.com.jessicalvs.gameList.model.Game
import br.com.jessicalvs.gameList.services.APIcall
import java.util.*

fun main() {

    val key = Scanner(System.`in`)
    println("insert a code to search:")
    val search = key.nextLine()

    var myGame: Game? = null

    //getting from api

    val result = runCatching {
        //setting the api call
        val apiSearch = APIcall()
        //calling the api with the id
        val infoGame = apiSearch.searchGame(search)
        //saving as the game
        myGame = Game(infoGame.info.title, infoGame.info.thumb);
        println(myGame)
    }

    result.onFailure {
        println("Game not found. Try another id")
    }
    result.onSuccess {
        println("Do you want to insert a description? Y/N")
        val option = key.nextLine()

        if (option.equals("y", ignoreCase = true)) {
            println("Insert description")
            val userDescription = key.nextLine()
            myGame?.description = userDescription

        } else {
            myGame?.description = myGame?.title
        }

        result.onSuccess {
            println(myGame)
            println("Success")
        }
    }
}