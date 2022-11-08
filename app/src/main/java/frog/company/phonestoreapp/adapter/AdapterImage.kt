package frog.company.phonestoreapp.adapter

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
import frog.company.phonestoreapp.databinding.ListHotBinding
import frog.company.phonestoreapp.databinding.ListPhoneBinding
import frog.company.phonestoreapp.databinding.ListSellerBinding
import frog.company.phonestoreapp.helper.IListenerClick
import frog.company.phonestoreapp.model.HotStore
import frog.company.phonestoreapp.ui.details.DetailsFragment


class AdapterImage(
    private val dataList : ArrayList<String>,
) : RecyclerView.Adapter<AdapterImage.ViewHolder>() {

    private lateinit var binding : ListPhoneBinding

    inner class ViewHolder(binding: ListPhoneBinding) : RecyclerView.ViewHolder(binding.root){
        var binding: ListPhoneBinding? = null

        init {
            this.binding = binding
        }
        fun bind(str: String) {
            Picasso.get().load(str).into(binding?.img)
            binding?.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding =
            ListPhoneBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}