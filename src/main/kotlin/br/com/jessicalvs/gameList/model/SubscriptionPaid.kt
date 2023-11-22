package br.com.jessicalvs.gameList.model

class SubscriptionPaid(
    type: String, val fee: Double,
    val gamesIncluded: Int, val discountPercent: Double, id: Int?
) : Subscription(type) {
    override var id : Int? = null


    override fun getRentValue(rent: Rent): Double {
        val totalGamesMonth = rent.gamer.monthlyGamesRent(rent.period.date.monthValue).size+1

        return if (totalGamesMonth <= gamesIncluded){
            0.0
        }else{
            var originalPrice = super.getRentValue(rent)
            if(rent.gamer.avg > 8){
                originalPrice -= originalPrice * discountPercent
            }
            return originalPrice
        }
    }

    override fun toString(): String {
        return super.toString()
    }

}