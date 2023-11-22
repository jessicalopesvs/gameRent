package br.com.jessicalvs.gameList.principal

import br.com.jessicalvs.gameList.data.DatabaseConection
import br.com.jessicalvs.gameList.data.GameDAO
import br.com.jessicalvs.gameList.model.Game

fun main() {


    val game = Game("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val game2 = Game("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", 9.99,"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")


    val manager = DatabaseConection.getEntityManager()
    val gameDao = GameDAO(manager)
//    gameDao.add(game2)


//    println(gameDao.getById(5))
    gameDao.deleteById(4)

    val gameList: List<Game> = gameDao.getList()
    println(gameList)

    manager.close()

}