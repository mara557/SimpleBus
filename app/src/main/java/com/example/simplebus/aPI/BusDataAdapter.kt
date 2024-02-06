package com.example.simplebus.aPI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simplebus.R

class BusDataAdapter(private val dataList: List<BusData>) :
    RecyclerView.Adapter<BusDataAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewOperatorName: TextView = itemView.findViewById(R.id.textViewOperatorName)
        private val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)

        fun bind(data: BusData) {
            textViewOperatorName.text = data.operatorName
            textViewDescription.text = data.description
            // Bind other data fields as needed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_bus_data, parent, false)
        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size
}
