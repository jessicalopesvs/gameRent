package br.com.jessicalvs.gameList.model

data class InfoGame (val info: infoApiShark){
    override fun toString(): String {
        return info.toString();
    }
}