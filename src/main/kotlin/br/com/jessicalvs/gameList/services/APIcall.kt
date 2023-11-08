package br.com.jessicalvs.gameList.services

import br.com.jessicalvs.gameList.model.Game
import br.com.jessicalvs.gameList.model.infoGame
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class APIcall {

    fun searchGame(id:String):infoGame{
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body();


        val gson = Gson()
        val myInfoGame = gson.fromJson(json, infoGame::class.java)

        return myInfoGame

    }


}