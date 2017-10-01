package com.tomazwang.project.kotlinandroid.data.model.db

import com.tomazwang.project.kotlinandroid.data.model.Task
import org.jetbrains.anko.db.*

/**
 * Created by TomazWang on 27/09/2017.
 */
class TaskDao {

    val rowParser = TaskRowParser()
    val db = DbHelper.instance

    fun insert(task: Task) = db.use {
        insert(
                TableTask.TABLE_NAME,
                TableTask.COL_TITLE to task.title,
                TableTask.COL_DESCRIPTION to task.description,
                TableTask.COL_CHECKED to task.checked.toString()
        )
    }

    fun getTaskFromId(id: Long) = db.use {
        select(TableTask.TABLE_NAME)
                .whereArgs("${TableTask.COL_ID} = {id}", "id" to id)
                .exec {
                    parseSingle(rowParser)
                }
    }

    val count = db.use {
        select(TableTask.TABLE_NAME)
                .column(TableTask.COL_ID)
                .exec {
                    this.count
                }
    }


    fun clearAll() = db.use {
        delete(TableTask.TABLE_NAME, null, null)
    }

    fun getAllTasks(): List<Task> = db.use{
        select(TableTask.TABLE_NAME)
                .exec { parseList(rowParser) }
    }


}

class TaskRowParser : MapRowParser<Task> {
    override fun parseRow(columns: Map<String, Any?>) = Task(
            id = columns[TableTask.COL_ID] as Long,
            title = columns[TableTask.COL_TITLE] as String,
            description = columns[TableTask.COL_DESCRIPTION] as String,
            checked = (columns[TableTask.COL_CHECKED] as String).toBoolean()
    )
}

