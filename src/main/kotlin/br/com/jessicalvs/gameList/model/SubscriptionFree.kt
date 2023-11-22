package br.com.jessicalvs.gameList.model

class SubscriptionFree(type : String) : Subscription(type){
    override var id : String? = null


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
