package com.example.powerofyou.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.powerofyou.BR
import com.example.powerofyou.R
import com.example.powerofyou.data.model.FinalArmor
import com.example.powerofyou.databinding.AmorItemBinding

class ArmorAdapter : ListAdapter<FinalArmor, ArmorAdapter.ArmorHolder>(ArmorDiffUtils()) {

    class ArmorHolder(binding: AmorItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val itemBinding: AmorItemBinding = binding
        fun bind(obj: Any?) {
            itemBinding.setVariable(BR.armor, obj)
            itemBinding.executePendingBindings()
        }
    }

    class ArmorDiffUtils : DiffUtil.ItemCallback<FinalArmor>() {
        override fun areItemsTheSame(oldItem: FinalArmor, newItem: FinalArmor): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: FinalArmor, newItem: FinalArmor): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArmorHolder {

        return ArmorHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.amor_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArmorHolder, position: Int) {

        holder.bind(getItem(position))
    }
}