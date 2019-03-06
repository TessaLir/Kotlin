package ru.vetukov.tutorial.kotlin_lesson_002.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*
import ru.vetukov.tutorial.kotlin_lesson_002.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter:NotesRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)


        main_rv_notes.layoutManager = GridLayoutManager(this, 1)
//        main_rv_notes.layoutManager = LinearLayoutManager(this, 0, false)
        adapter = NotesRVAdapter()
        main_rv_notes.adapter = adapter

        viewModel.viewState().observe(this, Observer { t ->
            t?.let { adapter.notes = it.notes }
        })
    }
}
