package frog.company.phonestoreapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import frog.company.phonestoreapp.R
import frog.company.phonestoreapp.databinding.ListCartBinding
import frog.company.phonestoreapp.databinding.ListHotBinding
import frog.company.phonestoreapp.databinding.ListSellerBinding
import frog.company.phonestoreapp.helper.IListenerClick
import frog.company.phonestoreapp.model.Basket
import frog.company.phonestoreapp.model.HotStore
import frog.company.phonestoreapp.ui.details.DetailsFragment

class AdapterCart(
    private val dataList : ArrayList<Basket>,
) : RecyclerView.Adapter<AdapterCart.ViewHolder>() {

    private lateinit var binding : ListCartBinding

    inner class ViewHolder(binding: ListCartBinding) : RecyclerView.ViewHolder(binding.root){
        var binding: ListCartBinding? = null

        init {
            this.binding = binding
        }
        fun bind(basket: Basket, position: Int) {
            binding?.basket = basket
            binding?.executePendingBindings()

            binding?.btnAdd?.setOnClickListener {
                dataList[position].count++
                notifyItemChanged(position)
                binding?.executePendingBindings()
            }

            binding?.btnMinus?.setOnClickListener {
                dataList[position].count--
                notifyItemChanged(position)
                if(dataList[position].count == 0){
                    dataList.removeAt(position)
                    notifyItemRemoved(position)
                }
                binding?.executePendingBindings()
            }

            binding?.imgRemove?.setOnClickListener {
                dataList.removeAt(position)
                notifyItemRemoved(position)
                binding?.executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding =
            DataBindingUtil.inflate(inflater, R.layout.list_cart, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position], position)
    }
}