package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fruits: ArrayList<Fruit> = ArrayList()
        fruits.add(Fruit("Manzana", R.drawable.manzana))
        fruits.add(Fruit("Durazno", R.drawable.durazno))
        fruits.add(Fruit("Sandia", R.drawable.sandia))
        fruits.add(Fruit("Platano", R.drawable.platano))

        val list = findViewById<ListView>(R.id.lvMain)

        // list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fruits)
        list.adapter = CustomAdapter(this, fruits)

        list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, fruits[position].name, Toast.LENGTH_SHORT).show()
        }
    }

}
