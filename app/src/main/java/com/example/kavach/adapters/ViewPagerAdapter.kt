package com.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kavach.R

class ViewPagerAdapter(
    private var title: List<String>,
    private var slogan: List<String>,
    private var image: List<Int>)
    : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.tv)
        val itemSlogan: TextView = itemView.findViewById(R.id.tvsl)
        val itemImage: ImageView = itemView.findViewById(R.id.splash)

        init {
            itemImage.setOnClickListener { v: View ->
                val position = adapterPosition
                Toast.makeText(itemView.context, "You clicked on item #${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.activity_splash_screen,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        // Skip the splash screen for normal pages
        if (position == 0) {
            holder.itemTitle.visibility = View.GONE
            holder.itemSlogan.visibility = View.GONE
        } else {
            holder.itemTitle.visibility = View.VISIBLE
            holder.itemSlogan.visibility = View.VISIBLE
            holder.itemTitle.text = title[position - 1]
            holder.itemSlogan.text = slogan[position - 1]
        }

        holder.itemImage.setImageResource(image[position])
    }

    override fun getItemCount(): Int {
        // Adding 1 for the splash screen
        return title.size + 1
    }
}
