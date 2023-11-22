package br.com.jessicalvs.gameList.data

import br.com.jessicalvs.gameList.model.Game
import java.beans.Statement
import javax.persistence.EntityManager
import javax.xml.crypto.Data

class GameDAO (manager: EntityManager) : DAO<Game, GameDTO> (manager, GameDTO::class.java){
    override fun toEntity(obj: Game) : GameDTO{
        return GameDTO(obj.title, obj.thumb,obj.price,obj.description)
    }

    override fun toModel(entity: GameDTO): Game {
        return  Game(entity.title, entity.thumb, entity.price, entity.description, entity.id);
    }





}