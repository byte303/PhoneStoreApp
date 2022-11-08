package frog.company.phonestoreapp.ui.details

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import frog.company.phonestoreapp.R
import frog.company.phonestoreapp.adapter.AdapterColor
import frog.company.phonestoreapp.adapter.AdapterImage
import frog.company.phonestoreapp.database.UtilsDb
import frog.company.phonestoreapp.model.Details
import frog.company.phonestoreapp.ui.my_cart.CartFragment

class DetailsViewModel : ViewModel() {

    var details = ObservableField(Details())

    var listPhone = ArrayList<String>()
    var adapterPhone = ObservableField(AdapterImage(listPhone))

    var listColor = ArrayList<String>()
    var adapterColor = ObservableField(AdapterColor(listColor))
    init {
        val utils = UtilsDb()

        val obs = Observer<Details?>{
            if(it != null){
                details.set(it)
                details.notifyChange()

                listColor.addAll(details.get()!!.color)
                listPhone.addAll(details.get()!!.images)

                adapterPhone.get()!!.notifyDataSetChanged()
                adapterColor.get()!!.notifyDataSetChanged()
            }
        }
        utils.getDetails().observeForever(obs)
        utils.onSelectDetails()
    }

    fun onBackPressed(view : View){
        (view.context as AppCompatActivity).supportFragmentManager.popBackStack()
    }

    fun onClickAdd(view : View){
        (view.context as AppCompatActivity).supportFragmentManager
            .beginTransaction()
            .add(R.id.viewPager, CartFragment())
            .addToBackStack(null)
            .commit()
    }
}