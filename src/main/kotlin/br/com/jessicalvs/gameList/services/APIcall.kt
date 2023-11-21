package br.com.jessicalvs.gameList.services

import br.com.jessicalvs.gameList.model.*
import br.com.jessicalvs.gameList.utilities.createGame
import br.com.jessicalvs.gameList.utilities.createGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class APIcall {

    private fun getData(url : String) : String{
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.body();
    }


//    fun searchGame(id: String): infoGame {
//        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"
//        val json = getData(url)
//
//        val gson = Gson()
//        return gson.fromJson(json, infoGame::class.java)
//
//    }

    fun searchGame(): List<Game> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = getData(url)

        val gson = Gson()
        val myTypeGame = object : TypeToken<List<InfoGameJson>>(){}.type
        val listGames : List<InfoGameJson> = gson.fromJson(json,myTypeGame)
        return listGames.map{
            infoGameJson -> infoGameJson.createGame()
        }

    }



    fun searchGamer(): List<Gamer> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = getData(url);

        val gson = Gson()
        val myTypeGamer = object : TypeToken<List<InfoGamerJson>>() {}.type
        val listGamer: List<InfoGamerJson> = gson.fromJson(json, myTypeGamer)

        return listGamer.map { infoGamerJson ->
            infoGamerJson.createGamer()
        }

    }


}