package com.example.weightmanagement.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weightmanagement.R
import com.example.weightmanagement.model.Data

class ExistListAdapter (private val dataList: MutableList<Data>): RecyclerView.Adapter<ExistListAdapter.ViewHolder>() {
    // Viewの初期化
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val existDate: TextView = view.findViewById(R.id.item_exist_date)
        val existWeight: TextView = view.findViewById(R.id.item_exist_weight)
        val existBodyFatPercentage: TextView = view.findViewById(R.id.item_exist_body_fat_percentage)
        val existBmi: TextView = view.findViewById(R.id.item_exist_bmi)
    }

    // レイアウトの設定
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(view)
    }

    // Viewの設定
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val data = dataList[position]

        viewHolder.existDate.text = data.date.toString()
        viewHolder.existWeight.text = data.weight.toString()
        viewHolder.existBodyFatPercentage.text = data.percentage.toString()
        viewHolder.existBmi.text = data.bmi.toString()
    }

    // 表示数を返す
    override fun getItemCount() = dataList.size
}