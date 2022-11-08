package frog.company.phonestoreapp.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import frog.company.phonestoreapp.R
import frog.company.phonestoreapp.databinding.ListColorBinding
import frog.company.phonestoreapp.databinding.ListHotBinding
import frog.company.phonestoreapp.databinding.ListPhoneBinding
import frog.company.phonestoreapp.databinding.ListSellerBinding
import frog.company.phonestoreapp.helper.IListenerClick
import frog.company.phonestoreapp.model.HotStore
import frog.company.phonestoreapp.ui.details.DetailsFragment


class AdapterColor(
    private val dataList : ArrayList<String>,
) : RecyclerView.Adapter<AdapterColor.ViewHolder>() {

    private lateinit var binding : ListColorBinding
    private var selectIndex = 0
    inner class ViewHolder(binding: ListColorBinding) : RecyclerView.ViewHolder(binding.root){
        var binding: ListColorBinding? = null

        init {
            this.binding = binding
        }
        fun bind(str: String, position : Int) {
            if(selectIndex == position){
                binding?.img?.visibility = View.VISIBLE
            }else
                binding?.img?.visibility = View.GONE

            Log.d("AdapterColor", str)
            binding?.linear?.backgroundTintList = ColorStateList.valueOf(Color.parseColor(str))

            binding?.linear?.setOnClickListener {
                selectIndex = position
                notifyDataSetChanged()
            }

            binding?.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding =
            ListColorBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position], position)
    }
}