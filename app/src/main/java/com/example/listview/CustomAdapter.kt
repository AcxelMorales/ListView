package com.example.listview

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var context: Context, items: ArrayList<Fruit>): BaseAdapter() {

    private var itemsClass: ArrayList<Fruit>? = null

    init {
        this.itemsClass = items
    }

    override fun getCount(): Int {
        return this.itemsClass?.size!!
    }

    override fun getItem(position: Int): Any {
        return this.itemsClass?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: ViewHolder?
        var view: View? = convertView

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.template, null)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            holder = view.tag as? ViewHolder
        }

        val item = getItem(position) as Fruit
        holder?.name?.text = item.name
        holder?.img?.setImageResource(item.img)

        return view!!
    }

    private class ViewHolder(view: View) {

        var name: TextView? = null
        var img: ImageView? = null

        init {
            this.name = view.findViewById(R.id.txtName)
            this.img = view.findViewById(R.id.imgFruit)
        }

    }

}
