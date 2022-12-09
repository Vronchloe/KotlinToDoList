package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = ToDoAdapter(mutableListOf())


        RVToDoItems.adapter = todoAdapter
        RVToDoItems.layoutManager = LinearLayoutManager(this)

        btnAddToDo.setOnClickListener{
            val todotitle = ETToDoTitle.text.toString()
            if(todotitle.isNotEmpty()){
                val todo = ToDo(todotitle)
                todoAdapter.AddToDo(todo)
                ETToDoTitle.text.clear()
            }
        }
        btnDelToDo.setOnClickListener{
            todoAdapter.deleteDoneToDos()
        }

    }
}