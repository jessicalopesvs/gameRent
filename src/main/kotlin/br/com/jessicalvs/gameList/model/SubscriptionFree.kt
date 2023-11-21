package br.com.jessicalvs.gameList.model

class SubscriptionFree(type : String) : Subscription(type){

    override fun getRentValue(rent: Rent): Double {
        var originalPrice = super.getRentValue(rent)

       if(rent.gamer.avg > 8){
            originalPrice -= originalPrice * 0.1
        }
        return originalPrice
    }
}
