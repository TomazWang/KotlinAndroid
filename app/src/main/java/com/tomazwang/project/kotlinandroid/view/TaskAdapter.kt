package com.tomazwang.project.kotlinandroid.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tomazwang.project.kotlinandroid.R
import com.tomazwang.project.kotlinandroid.data.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

/**
 * Created by TomazWang on 24/09/2017.
 */
class TaskAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_task))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtTitle: TextView = itemView.findViewById(R.id.txt_title)

        fun bind(task: Task) = with(itemView) {
            txtTitle.text = task.title
            checkBox.isChecked = task.checked
            setOnClickListener { }
        }
    }

}

private fun ViewGroup.inflate(layoutRes: Int): View {
    val inflater = LayoutInflater.from(context)
    return inflater.inflate(layoutRes, this, false)
}
