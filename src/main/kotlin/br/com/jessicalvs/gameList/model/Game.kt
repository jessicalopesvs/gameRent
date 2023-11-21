package br.com.jessicalvs.gameList.model

import com.google.gson.annotations.Expose
import java.util.*

data class Game(@Expose val title: String,
                @Expose var thumb: String) : Recommendation{

    //    val = you can't modify just if you change the var
    var description: String? = null
    var price: Double = 0.0
    val scoreList = mutableListOf<Int>()

    override val avg: Double
        get() = scoreList.average()
    override fun recomend(score: Int) {
        scoreList.add(score)
    }

    constructor(title : String, thumb: String, price: Double, description: String) : this(title,thumb) {
        this.price = price
        this.description = description
    }

    override fun toString(): String {
        return "title: $title\nthumb: $thumb\ndescription: $description\n price: $price \n score: $avg"
    }

    companion object {

        fun createGame(sc: Scanner): Game {
            val title = sc.nextLine()
            val thumbnail = sc.nextLine()
            val price: Double = sc.nextDouble()
            val description = sc.nextLine()


            return Game(title, thumbnail, price, description);
        }
    }

}