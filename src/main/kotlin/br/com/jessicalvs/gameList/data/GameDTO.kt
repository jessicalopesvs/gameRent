package br.com.jessicalvs.gameList.data

import javax.persistence.*

@Entity
@Table(name = "games")
class GameDTO(val title : String = "game title",
                   val thumb: String = "thumb",
                   val price: Double = 0.0,
                   val description : String? = null,
                   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                   val id : Int = 0) {

}