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

        val fruits: ArrayList<String> = ArrayList()
        fruits.add("Manzana")
        fruits.add("Platano")
        fruits.add("Durazno")
        fruits.add("Guayaba")
        fruits.add("Pera")

        val list = findViewById<ListView>(R.id.lvMain)

        list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fruits)

        list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, fruits[position], Toast.LENGTH_SHORT).show()
        }
    }

}
