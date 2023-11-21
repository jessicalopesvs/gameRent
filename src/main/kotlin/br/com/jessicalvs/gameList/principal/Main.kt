package br.com.jessicalvs.gameList.principal

import ageConverter
import br.com.jessicalvs.gameList.model.Game
import br.com.jessicalvs.gameList.model.Gamer
import br.com.jessicalvs.gameList.services.APIcall
import java.util.*

fun main() {

    val sc = Scanner(System.`in`)

    //add/create a gammer
    val gamer = Gamer.createGamer(sc)
    println("Registers done. Check your data:")
    println(gamer)
    println("Gammer age: " + gamer.birthdate?.ageConverter())

    do {

        println("insert a code to search:")
        val search = sc.nextLine()

        var myGame: Game? = null

        //getting from api

        val result = runCatching {
            //setting the api call
            val apiSearch = APIcall()
            //calling the api with the id
            val infoGame = apiSearch.searchGame(search)
            //saving as the game
            myGame = Game(infoGame.info.title, infoGame.info.thumb);
//            println(myGame)
        }

        result.onFailure {
            println("Game not found. Try another id")
        }
        result.onSuccess {
            println("Do you want to insert a description? Y/N")
            val option = sc.nextLine()

            if (option.equals("y", ignoreCase = true)) {
                println("Insert description")
                val userDescription = sc.nextLine()
                myGame?.description = userDescription

                println(myGame)

            } else {
                myGame?.description = myGame?.title
            }

            gamer.searches.add(myGame);

        }
        result.onSuccess {
            println("Success")
        }

        println("Do you want to search for another game? Y/N")
        val opt = sc.nextLine()
    } while (opt.equals("y", true))

    println("list of games searched")
    println(gamer.searches)

    println("\nTitle ordered games\n")
    gamer.searches.sortBy {
        it?.title

    }

    gamer.searches.forEach{
        println("Title: " + it?.title)
    }

    val filteredGames = gamer.searches.filter {
        it?.title?.contains("Batman", true) ?: false
    }
    println("\nFiltered game")
    println(filteredGames)

    //exclude item from the list
    println("Do you want to delete any game from the list? Y/N")
    val asw = sc.nextLine()

    if(asw.equals("y",true)){
        println("\nThis is the list")
        println(gamer.searches)

        println("Which position on the list you want to delete?")
        val position = sc.nextInt()
        gamer.searches.removeAt(position)

        println ("\nUpdated list")
        println(gamer.searches)
    }


    println("Search finished with exit code N")
}