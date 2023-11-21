package br.com.jessicalvs.gameList.model

import java.util.*

data class Game (val title:String, var thumb:String, var price : Double, var description: String){

    //    val = you can't modify just if you change the var

    override fun toString(): String {
        return "title: $title\nthumb: $thumb\ndescription: $description\n price: $price"
    }

    companion object{

        fun createGame (sc : Scanner) : Game {
            val title = sc.nextLine()
            val thumbnail = sc.nextLine()
            val price : Double = sc.nextDouble()
            val description = sc.nextLine()


            return Game(title, thumbnail,price, description);
        }
    }

}