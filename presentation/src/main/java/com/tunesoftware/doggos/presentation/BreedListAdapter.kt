package com.tunesoftware.doggos.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.tunesoftware.doggos.domain.Breed
import com.tunesoftware.doggos.presentation.databinding.ListItemBreedBinding

class BreedListAdapter(private val onClick: (Breed, View) -> Unit):
    ListAdapter<Breed, BreedListAdapter.BreedListViewHolder>(BreedListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_breed, parent, false)
        return BreedListViewHolder(view)
    }

    override fun onBindViewHolder(holder: BreedListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BreedListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemBreedBinding.bind(itemView)

        fun bind(item: Breed) {
            with (itemView) {
                binding.imgBreed.load(item.imageUrl)
                binding.txtBreedName.text = item.name
                binding.txtGroup.text = item.group

                ViewCompat.setTransitionName(binding.imgBreed, item.name)
                setOnClickListener { onClick(item, binding.imgBreed) }
            }
        }
    }

    class BreedListDiffCallback: DiffUtil.ItemCallback<Breed>() {

        override fun areItemsTheSame(oldItem: Breed, newItem: Breed) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Breed, newItem: Breed) = oldItem == newItem
    }
}