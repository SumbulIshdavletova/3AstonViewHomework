package ru.sumbul.a3aston

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent
import ru.sumbul.a3aston.databinding.FlagCardBinding


class MyAdapter(
    private val countries: Array<String>,
    private val flags: Array<Int>
) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FlagCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.textView.text = countries[position]
        viewHolder.imageView.setImageResource(flags[position])
    }

    override fun getItemCount() = countries.size

}

class ViewHolder(binding: FlagCardBinding) : RecyclerView.ViewHolder(binding.root) {
    val textView: TextView
    val imageView: ImageView

    init {
        textView = binding.textView
        imageView = binding.imageView
    }
}