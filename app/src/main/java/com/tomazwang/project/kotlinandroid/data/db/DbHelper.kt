package com.tomazwang.project.kotlinandroid.data.model.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.tomazwang.project.kotlinandroid.App
import org.jetbrains.anko.db.*


/**
 * Created by TomazWang on 27/09/2017.
 */
class DbHelper(context: Context = App.instance) : ManagedSQLiteOpenHelper(context, "task.db", null, DbContract.VERSION) {

    companion object {
        val instance by lazy {
            DbHelper()
        }
    }


    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(/**/
                tableName = TableTask.TABLE_NAME,
                ifNotExists = true,
                columns = *arrayOf(
                        TableTask.COL_ID to INTEGER + PRIMARY_KEY,
                        TableTask.COL_TITLE to TEXT,
                        TableTask.COL_DESCRIPTION to TEXT,
                        TableTask.COL_CHECKED to TEXT
                )
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(TableTask.TABLE_NAME, true)

    }


}