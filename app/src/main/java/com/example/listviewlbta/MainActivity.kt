package com.example.listviewlbta

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //=====reference to the list view===

        val listview = findViewById<ListView>(R.id.main_listview)

        //val redColor = Color.parseColor("#FF0000")
        //listview.setBackgroundColor(redColor)

        listview.adapter = MyCustomAdapter(this)  //contruct it with empty constructer --> ()
    }


    //========class for adapter
//public abstract gets view with all of its parameters,   BaseAdaper() ---> constructor for my class

    private class MyCustomAdapter(context: Context) :BaseAdapter() {

        //we passed context because we need to use it later on

        private  val mContext: Context

        //to have acces to the context varraible from the constructor, we use init
        init {
            mContext = context
        }

        //responsible for how many rows in a list
        override fun getCount(): Int {
            return 5
        }


        //can be ignored, implemneted to let the error go away
        override fun getItemId(position: Int): Long {

            return position.toLong()
        }

        //can be ignored, implemneted to let the error go away
        override fun getItem(position: Int): Any {

            return "TEST STRING"
        }

         //responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

      val textView = TextView(mContext) //return view for individual row
             textView.text = "Here is my row for my text view"
             return textView


        }

    }
}
