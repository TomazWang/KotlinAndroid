package com.tomazwang.project.kotlinandroid.data.model

/**
 * Created by TomazWang on 25/09/2017.
 */
data class Task(
        val id: Long = 0,
        val title: String = "",
        val description: String = "",
        val checked: Boolean = false
)

