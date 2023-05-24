package com.example.cosscan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IngAdapter: RecyclerView.Adapter<IngAdapter.IngViewHolder>() {
    private var list:ArrayList<String>  = ArrayList()

    fun addItems(items: ArrayList<String>) {
        this.list = items
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = IngViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.ing_item, parent, false)
    )

    override fun onBindViewHolder(holder: IngViewHolder, position: Int) {
          val ing = list[position]
          holder.bindView(ing)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class IngViewHolder(var view: View): RecyclerView.ViewHolder(view){

        private var ingy = view.findViewById<TextView>(R.id.ingId)
        fun bindView(ing: String){
            ingy.text = ing


        }

    }
}