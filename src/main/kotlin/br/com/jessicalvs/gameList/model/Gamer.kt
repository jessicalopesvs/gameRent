package br.com.jessicalvs.gameList.model

import java.lang.IllegalArgumentException
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name: String, var email: String) : Recommendation {
    var birthdate: String? = null
    var username: String? = null
        //setting id
        set(value) {
            field = value
            if (id.isNullOrBlank()) {
                createID();
            }
        }
    var id: String? = null
        private set
    val searches = mutableListOf<Game?>()
    val rentedGames = mutableListOf<Rent?>()

    var subscription: Subscription = SubscriptionFree("BRONZE")


    constructor(name: String, email: String, birthdate: String, username: String) :
            this(name, email) {
        this.birthdate = birthdate
        this.username = username
    }

    init {
        if (name.isNullOrBlank()) {
            throw IllegalArgumentException("Name is blank")
        }
        this.email = validateEmail()
    }

    override fun toString(): String {
        return "\nGamer Data\n" +
                "name : $name" +
                "\nemail: $email" +
                "\nbirthdate: $birthdate" +
                "\nusername: $username" +
                "\nid: $id\n" +
                "Reputation: ${avg}"
    }

    fun createID() {
        val randomNum = Random.nextInt(1000)
        val tag = String.format("%04d", randomNum)

        id = "$username#$tag"
    }


    fun validateEmail(): String {

        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Invalid e-mail")
        }
    }

    //Rental function

    fun rentGame(game: Game, period: PeriodRental): Rent {
        val rent = Rent(this, game, period)
        rentedGames.add(rent)
        return rent
    }

    fun monthlyGamesRent(mth: Int): List<Game> {
        return rentedGames
            .filter { rent -> rent!!.period.date.monthValue == mth }
            .map { rent -> rent!!.game }

    }

    //creating gamer
    companion object {
        fun createGamer(sc: Scanner): Gamer {
            println("Welcome to GameRent! To start your registrations, write your name: ")
            val name = sc.nextLine()
            println("Write your e-mail:")
            val email = sc.nextLine()
            println("Do you want to compleat your registration? (Y/N)")
            val option = sc.nextLine()

            if (option.equals("y", true)) {
                println("Whats your birthdate(DD/MM/AAAA):")
                val birthdate = sc.nextLine()
                println("Write your username:")
                val username = sc.nextLine()
                return Gamer(name, email, birthdate, username)
            } else {
                return Gamer(name, email)
            }


        }
    }

    //Ratings

    private val listRating = mutableListOf<Int>()
    val gameRatings = mutableListOf<Game>()
    override val avg: Double
        get() = listRating.average()

    override fun recomend(score: Int) {
        listRating.add(score)
    }

    fun recomendGame(game: Game, score: Int) {

        game.recomend(score)
        gameRatings.add(game)

    }

}
