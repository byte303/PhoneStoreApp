package frog.company.phonestoreapp.ui.my_cart

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import frog.company.phonestoreapp.adapter.AdapterCart
import frog.company.phonestoreapp.database.UtilsDb
import frog.company.phonestoreapp.model.Basket
import frog.company.phonestoreapp.model.Cart

class CartViewModel : ViewModel() {

    var cart = ObservableField(Cart())
    var list = ArrayList<Basket>()
    var adapterCart = ObservableField(AdapterCart(list))

    init {
        val utils = UtilsDb()

        val obs = Observer<Cart?>{
            if(it != null){
                cart.set(it)
                cart.notifyChange()
                list.addAll(cart.get()!!.basket)
                adapterCart.get()!!.notifyDataSetChanged()
            }
        }
        utils.getCart().observeForever(obs)
        utils.onSelectCart()
    }

    fun onBackPressed(view : View){
        (view.context as AppCompatActivity).supportFragmentManager.popBackStack()
    }
}