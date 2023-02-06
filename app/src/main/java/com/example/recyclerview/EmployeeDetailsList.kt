package com.example.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class EmployeeDetailsList(private val context: Context, private var employeeDetails: List<Details>) :
    RecyclerView.Adapter<EmployeeDetailsList.DetailsViewHolder>() {

    inner class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemText: TextView
        var favoriteItem: ImageButton
        init {
            Log.d("inner Class", "inside init")
            itemText = itemView.findViewById(R.id.tvDetails) as TextView
            favoriteItem = itemView.findViewById(R.id.btnFavourite)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        Log.d("onCreateViewHolder", "inside on create")
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_employee_detail, parent, false)
        return DetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        Log.d("onBindViewHolder", "inside the on bind")
        holder.itemText.text = employeeDetails[position].details
        holder.favoriteItem.setOnClickListener{
            if (!employeeDetails[position].isFavorite) {
                it.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
                employeeDetails[position].isFavorite = true
                holder.itemView.setBackgroundResource(employeeDetails[position].pic)
            } else{
                employeeDetails[position].isFavorite = false
                holder.favoriteItem.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
            }
        }
        if (employeeDetails[position].isFavorite) {
            holder.favoriteItem.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
        }
    }

    override fun getItemCount(): Int {
        Log.d("getItemCount", "inside the on getItemCount")
        return employeeDetails.size
    }

}
