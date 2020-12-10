package com.example.course

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(),AdapterMain.OnClickItemCourse {

    private lateinit var viewAdapter: AdapterMain
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var data : ArrayList<Course> = ArrayList()
    private var callback: CourseSelected? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity.let {
            toolbar.apply {
                title = context.getString(R.string.lbl_title_main_toolbar)
                subtitle = context.getString(R.string.lbl_subtitle_main_toolbar)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        initialRecycler()
    }

    private fun initialRecycler(){
        //TODO Rojo, Will En esta lista estatica pueden agregar el tema que quieran
        data.add(Course(1,"Drawables","Manipulación de drawables, multiples capas, formas y propiedades"))
        data.add(Course(2,"MVVM","Consumo de API con patron MMVM, LiveData, Databinding y persistencia en Room"))
        data.add(Course(3,"MVVM","Consumo de API con patron MMVM, LiveData, Databinding y persistencia en Room"))
        data.add(Course(4,"MVVM","Consumo de API con patron MMVM, LiveData, Databinding y persistencia en Room"))
        data.add(Course(5,"MVVM","Consumo de API con patron MMVM, LiveData, Databinding y persistencia en Room"))
        data.add(Course(6,"MVVM","Consumo de API con patron MMVM, LiveData, Databinding y persistencia en Room"))
        data.add(Course(7,"MVVM","Consumo de API con patron MMVM, LiveData, Databinding y persistencia en Room"))
        data.add(Course(8,"MVVM","Consumo de API con patron MMVM, LiveData, Databinding y persistencia en Room"))
        data.add(Course(9,"MVVM","Consumo de API con patron MMVM, LiveData, Databinding y persistencia en Room"))

        rv_courses.apply {
            setHasFixedSize(true)
            viewManager = LinearLayoutManager(context)
            viewAdapter = AdapterMain(data,this@MainFragment)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.let { if (it is CourseSelected) callback = it }
    }

    companion object {
        fun newInstance() = MainFragment()
        val TAG = MainFragment::class.java.canonicalName
    }

    override fun clickCourse(position: Int) { callback?.onCourseSelected(position) }

    interface CourseSelected { fun onCourseSelected(position: Int) }

}