package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val datas: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = object : Adapter<ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view = LayoutInflater.from(this@MainActivity).inflate(android.R.layout.simple_list_item_1, null)
                return ListViewHolder(view)
            }

            override fun getItemCount(): Int {
                return datas.count()
            }

            fun test(){

            }
            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                (holder.itemView as TextView).text = datas[position]
            }

        }
        add.setOnClickListener {
            datas.add("this is position = " + datas.size)
            (recycler.adapter as Adapter<ViewHolder>).notifyDataSetChanged()

        }
    }

    class ListViewHolder(view : View) : ViewHolder(view)
}
