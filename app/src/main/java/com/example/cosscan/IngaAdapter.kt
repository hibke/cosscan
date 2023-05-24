package com.example.cosscan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IngaAdapter: RecyclerView.Adapter<IngaAdapter.IngaViewHolder>() {
    private var list: ArrayList<String> = ArrayList()

    fun addItems(items: ArrayList<String>) {
        this.list = items
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = IngaViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.inga_item, parent, false)
        )

    override fun onBindViewHolder(holder: IngaViewHolder, position: Int) {
        val ing = list[position]
        holder.bindView(ing)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class IngaViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        private var ingy = view.findViewById<TextView>(R.id.ingaId)
        fun bindView(ing: String) {
            ingy.text = ing


        }
    }

}