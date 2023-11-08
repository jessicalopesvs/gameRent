data class Game (val title:String, var thumb:String){

    //    val = you can't modify just if you change the var
    var description: String? = null
    override fun toString(): String {
        return "Game\n" +
                "title: $title\nthumb: $thumb\ndescription: $description"
    }


}