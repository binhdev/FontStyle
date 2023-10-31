package com.amzuni.fontstyle.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.amzuni.fontstyle.R
import com.amzuni.fontstyle.model.Style


class StyleAdapter(var context: Context, private var styleList: MutableList<Style>) :
    RecyclerView.Adapter<StyleAdapter.ViewHolder>() {

    class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName : TextView
        private val tvValue : TextView
        init {
            tvName = itemView.findViewById(R.id.tv_name)
            tvValue = itemView.findViewById(R.id.tv_value)
        }

        fun bind(style: Style){
            tvName.text = style.name
            tvValue.text = style.value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_style, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val style = styleList[position]

        holder.bind(style)
        holder.itemView.setOnClickListener {
            (context.getSystemService("clipboard") as ClipboardManager).setPrimaryClip(
                ClipData.newPlainText("label", style.value)
            )
        }
    }
    override fun getItemCount(): Int = styleList.size

}