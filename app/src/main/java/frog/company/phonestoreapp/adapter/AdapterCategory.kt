package frog.company.phonestoreapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import frog.company.phonestoreapp.R
import frog.company.phonestoreapp.databinding.ListCategoryBinding
import frog.company.phonestoreapp.model.Category


class AdapterCategory(
    private val dataList : ArrayList<Category>,
) : RecyclerView.Adapter<AdapterCategory.ViewHolder>() {

    private lateinit var binding : ListCategoryBinding
    private var selectedIndex = 0

    inner class ViewHolder(binding: ListCategoryBinding) : RecyclerView.ViewHolder(binding.root){
        var binding: ListCategoryBinding? = null

        init {
            this.binding = binding
        }
        fun bind(category: Category, position: Int) {
            binding?.category = category
            binding?.executePendingBindings()

            if(position == selectedIndex)
                dataList[position].flag = true

            binding?.floatingActionButton!!.setOnClickListener {
                dataList[selectedIndex].flag = false
                notifyItemChanged(selectedIndex)

                selectedIndex = position

                dataList[position].flag = true
                notifyItemChanged(position)


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding =
            DataBindingUtil.inflate(inflater, R.layout.list_category, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position], position)
    }
}