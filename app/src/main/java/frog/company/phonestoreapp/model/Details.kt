package frog.company.phonestoreapp.model

@kotlinx.serialization.Serializable
data class Details(
    var CPU : String = "",
    var camera : String = "",
    var capacity : ArrayList<Int> = ArrayList(),
    var color : ArrayList<String> = ArrayList(),
    var id : String = "",
    var images : ArrayList<String> = ArrayList(),
    var isFavorites : Boolean = false,
    var price : Double = 0.0,
    var rating : Float = 0f,
    var sd : String = "",
    var ssd : String = "",
    var title : String = ""
)
