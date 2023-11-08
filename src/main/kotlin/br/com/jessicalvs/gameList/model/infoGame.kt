package br.com.jessicalvs.gameList.model

data class infoGame (val info: infoApiShark){
    override fun toString(): String {
        return info.toString();
    }
}