package br.com.jessicalvs.gameList.model

interface Recommendation {
    val avg : Double
    fun recomend(score : Int)

}