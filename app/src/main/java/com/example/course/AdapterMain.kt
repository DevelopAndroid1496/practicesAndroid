package com.example.course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.callbackFlow

class AdapterMain(private var dataSet: ArrayList<Course>,var callback: OnClickItemCourse): RecyclerView.Adapter<AdapterMain.CourseHolder>() {

    inner class CourseHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val cv_item_courses = view.findViewById<CardView>(R.id.cv_item_courses)
        val name_course = view.findViewById<TextView>(R.id.tv_name_item_main)
        val desc_course = view.findViewById<TextView>(R.id.tv_desc_item_main)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMain.CourseHolder = CourseHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_main,parent,false))

    override fun onBindViewHolder(mainHolder: AdapterMain.CourseHolder, position: Int) {
        val course = dataSet[position]
        mainHolder.apply {
            name_course.text = course.name
            desc_course.text = course.desc
            cv_item_courses.setOnClickListener {
               callback.clickCourse(position)
            }
        }
    }
    override fun getItemCount() : Int  = dataSet.size

    interface OnClickItemCourse { fun clickCourse(position: Int) }
}