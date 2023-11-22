package br.com.jessicalvs.gameList.model

class SubscriptionFree(type: String, id: Int?) : Subscription(type){
    override var id : Int? = null


    override fun getRentValue(rent: Rent): Double {
        var originalPrice = super.getRentValue(rent)

       if(rent.gamer.avg > 8){
            originalPrice -= originalPrice * 0.1
        }
        return originalPrice
    }

    override fun toString(): String {
        return super.toString()
    }
}
