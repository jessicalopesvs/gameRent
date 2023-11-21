package br.com.jessicalvs.gameList.model

import java.lang.IllegalArgumentException
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name: String, var email: String) {
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
        return "Gamer\n" +
                "name : $name" +
                "\nemail: $email" +
                "\nbirthdate: $birthdate" +
                "\nnusername: $username" +
                "\nid: $id"
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

    companion object{
        fun createGamer(sc : Scanner): Gamer {
            println("Welcome to GameRent! To start your registrations, write your name: ")
            val name = sc.nextLine()
            println("Write your e-mail:")
            val email = sc.nextLine()
            println("Do you want to compleat your registration? (Y/N)")
            val option = sc.nextLine()

            if(option.equals("y", true)){
                println("Whats your birthdate(DD/MM/AAAA):")
                val birthdate = sc.nextLine()
                println("Write your username:")
                val username =sc.nextLine()
                return Gamer (name, email,birthdate,username)
            }else{
                return Gamer(name,email)
            }


        }
    }


}
