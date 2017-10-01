package com.tomazwang.project.kotlinandroid.data.model.db

/**
 * Created by TomazWang on 27/09/2017.
 */

object DbContract {
    private val VERSION_MAJOR = 0
    private val VERSION_MINOR = 1
    val VERSION: Int = VERSION_MAJOR * 1000 + VERSION_MINOR

}

object TableTask {
    val TABLE_NAME = "task"
    val COL_TITLE = "title"
    val COL_ID = "_id"
    val COL_DESCRIPTION = "description"
    val COL_CHECKED = "checked"

}

