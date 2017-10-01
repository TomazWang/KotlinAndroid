package com.tomazwang.project.kotlinandroid.data.db

import android.support.test.espresso.matcher.ViewMatchers.assertThat
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.tomazwang.project.kotlinandroid.data.model.Task
import com.tomazwang.project.kotlinandroid.data.model.db.TaskDao
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.CoreMatchers.`is` as Is

/**
 * Created by TomazWang on 28/09/2017.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class TaskDaoTest {

    val dao = TaskDao()
    val idMap = mutableMapOf<Long, Task>()


    @Before
    fun setUp() {
        dao.clearAll()
        idMap.clear()

        for (i in 1..10) {
            val title = "task_$i"
            val checked = (i % 2 == 0)

            val task = Task(title = title, checked = checked)
            print("inserting task $i to db")
            val id = dao.insert(task)

            print("puting task $i to map")
            idMap[id] = task

        }

    }

    @Test
    fun testInsert() {
        assertThat(dao.count, Is(10))
    }

    @Test
    fun testGetTaskFromId() {
        idMap.forEach { id, task ->
            val taskInDb = dao.getTaskFromId(id)

            assertThat(taskInDb.title, Is(task.title))
            assertThat(taskInDb.checked, Is(task.checked))
        }


    }
}