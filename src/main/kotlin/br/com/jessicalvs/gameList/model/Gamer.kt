package br.com.jessicalvs.gameList.model

import java.lang.IllegalArgumentException
import kotlin.random.Random

data class Gamer(var name: String, var email: String) {
    var birthdate: String? = null
    var username:String? = null
        //setting id
        set(value) {
            field = value
            if(id.isNullOrBlank()){
                createID();
            }
        }
    var id:String? = null
    private set


    constructor(name: String, email: String, birthdate : String, username : String):
            this(name, email){
                this.birthdate = birthdate
                this.username = username
            }

    init {
        if(name.isNullOrBlank()){
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

    fun createID(){
        val randomNum = Random.nextInt(1000)
        val tag = String.format("%04d",randomNum)

        id = "$username#$tag"
    }

    fun validateEmail() : String{

        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)){
            return email
        }else{
            throw IllegalArgumentException("Invalid e-mail")
        }


    }


}
