package br.com.jessicalvs.gameList.utilities

import br.com.jessicalvs.gameList.model.Gamer
import br.com.jessicalvs.gameList.model.InfoGamerJson

fun InfoGamerJson.createGamer() : Gamer{
    return  Gamer(this.nome,this.email,this.email,this.usuario)
}