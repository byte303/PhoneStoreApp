package frog.company.phonestoreapp.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class HotStore(
    var id : Int = 0,
    @SerialName("is_new")
    var isNew : Boolean = false,
    var title : String = "",
    var subtitle : String = "",
    var picture : String = "",
    @SerialName("is_buy")
    var isBuy : Boolean = false,
    @SerialName("is_favorites")
    var isFavorites : Boolean = false,
    @SerialName("discount_price")
    var discountPrice : Int = 0,
    @SerialName("price_without_discount")
    var priceWithoutDiscount : Int = 0,
)
