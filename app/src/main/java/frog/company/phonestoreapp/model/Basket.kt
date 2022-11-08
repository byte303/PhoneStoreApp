package frog.company.phonestoreapp.model

@kotlinx.serialization.Serializable
data class Basket(
    var id : Int = 0,
    var images : String = "",
    var price : Double = 0.0,
    var title : String = "",
    var count : Int = 2
)