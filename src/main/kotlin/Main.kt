import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

fun main() {

    val key = Scanner(System.`in`)
    println("insert a code to search:")
    val search = key.nextLine()
    val url = "https://www.cheapshark.com/api/1.0/games?id=$search"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build()

    val response = client.send(request, BodyHandlers.ofString())

    val json = response.body();


    val gson = Gson()
    var myGame: Game? = null

    //getting from api

    val result = runCatching {
        val myInfoGame = gson.fromJson(json, infoGame::class.java)
        //saving as the game
        myGame = Game(myInfoGame.info.title, myInfoGame.info.thumb);
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
            print(myGame)
            println("Success")
        }


    }

}