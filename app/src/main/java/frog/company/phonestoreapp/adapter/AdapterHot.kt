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
import frog.company.phonestoreapp.databinding.ListHotBinding
import frog.company.phonestoreapp.helper.IListenerClick
import frog.company.phonestoreapp.model.HotStore
import frog.company.phonestoreapp.ui.details.DetailsFragment


class AdapterHot(
    private val dataList : ArrayList<HotStore>,
) : RecyclerView.Adapter<AdapterHot.ViewHolder>(), IListenerClick {

    private lateinit var binding : ListHotBinding

    inner class ViewHolder(binding: ListHotBinding) : RecyclerView.ViewHolder(binding.root){
        var binding: ListHotBinding? = null

        init {
            this.binding = binding
            binding.listener = this@AdapterHot
        }
        fun bind(hot: HotStore) {
            binding?.hot = hot
            binding?.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding =
            DataBindingUtil.inflate(inflater, R.layout.list_hot, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun onCLickPhone(phone: HotStore) {
        (binding.root.context as AppCompatActivity).supportFragmentManager
            .beginTransaction()
            .add(R.id.viewPager, DetailsFragment())
            .addToBackStack(null)
            .commit()
    }

}