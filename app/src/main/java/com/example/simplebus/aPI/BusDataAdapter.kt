package com.example.simplebus.aPI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplebus.R
import kotlinx.android.synthetic.main.list_item_bus_data.view.*

class BusDataAdapter(private val dataList: List<BusData>) :
    RecyclerView.Adapter<BusDataAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: BusData) {
            itemView.apply {
                textViewOperatorName.text = data.operatorName
                textViewDescription.text = data.description
                // Bind other data fields as needed
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_bus_data, parent, false)
        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size
}
