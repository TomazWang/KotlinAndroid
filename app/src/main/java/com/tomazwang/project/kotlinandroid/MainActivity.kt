package com.tomazwang.project.kotlinandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.tomazwang.project.kotlinandroid.data.model.db.TaskDao
import com.tomazwang.project.kotlinandroid.view.TaskAdapter
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapter = TaskAdapter(TaskDao().getAllTasks())
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        with(fab) {
            setOnClickListener {

            }
        }
    }
}
