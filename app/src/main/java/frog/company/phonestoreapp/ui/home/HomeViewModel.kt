package frog.company.phonestoreapp.ui.home

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import frog.company.phonestoreapp.R
import frog.company.phonestoreapp.adapter.AdapterCategory
import frog.company.phonestoreapp.adapter.AdapterHot
import frog.company.phonestoreapp.adapter.AdapterSeller
import frog.company.phonestoreapp.database.UtilsDb
import frog.company.phonestoreapp.model.Category
import frog.company.phonestoreapp.model.HotStore
import frog.company.phonestoreapp.ui.BottomDialogFilter

class HomeViewModel : ViewModel() {

    private var arrayHot = ArrayList<HotStore>()
    var adapterHot = ObservableField(AdapterHot(arrayHot))

    private var arraySeller = ArrayList<HotStore>()
    var adapterSeller = ObservableField(AdapterSeller(arraySeller))

    var adapterCategory = ObservableField(AdapterCategory(arrayListOf(
        Category("Phones", R.drawable.icon_4, true),
        Category("Computer", R.drawable.icon_3),
        Category("Health", R.drawable.icon_2),
        Category("Books", R.drawable.icon_1)
    )))

    init {
        val utils = UtilsDb()

        val obs = Observer<ArrayList<HotStore>?>{
            if(it != null){
                arrayHot.addAll(it)
                adapterHot.get()!!.notifyDataSetChanged()
            }
        }
        utils.getListHot().observeForever(obs)

        val obsSeller = Observer<ArrayList<HotStore>?>{
            if(it != null){
                arraySeller.addAll(it)
                adapterSeller.get()!!.notifyDataSetChanged()
            }
        }
        utils.getListSeller().observeForever(obsSeller)

        utils.onSelectHot()
    }

    fun onClickFilter(view : View){
        val dialogFragment = BottomDialogFilter()
        dialogFragment.show((view.context as AppCompatActivity).supportFragmentManager, dialogFragment.tag)
    }
}