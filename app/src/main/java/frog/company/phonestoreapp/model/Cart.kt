package frog.company.phonestoreapp.model

@kotlinx.serialization.Serializable
data class Cart(
    var basket : ArrayList<Basket> = ArrayList(),
    var delivery : String = "",
    var id : Int = 0,
    var total : Double = 0.0
)
