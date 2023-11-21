package br.com.jessicalvs.gameList.utilities

import br.com.jessicalvs.gameList.model.Game
import br.com.jessicalvs.gameList.model.InfoGameJson

fun InfoGameJson.createGame() : Game{
    return Game(this.titulo,this.capa, this.preco, this.descricao)
}