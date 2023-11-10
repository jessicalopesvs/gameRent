package br.com.jessicalvs.gameList.principal

import br.com.jessicalvs.gameList.model.Gamer

fun main() {
    val gammer1 = Gamer(
        "Jessica",
        "jessica.lopesvs@gmail.com"
    );

    println(gammer1)

    gammer1.let {
        it.birthdate = "24/03/1992"
        it.username = "jeus"
    }.also { println("---------------------\n" + gammer1) }



}