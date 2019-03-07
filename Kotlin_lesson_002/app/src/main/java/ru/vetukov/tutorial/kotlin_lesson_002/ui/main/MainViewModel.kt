package ru.vetukov.tutorial.kotlin_lesson_002.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ru.vetukov.tutorial.kotlin_lesson_002.data.NotesRepository

class MainViewModel(private val repository: NotesRepository = NotesRepository) : ViewModel() {

    private val viewStateLiveData : MutableLiveData<MainViewState> = MutableLiveData()

    init {
        repository.getNotes().observeForever { notes ->
            viewStateLiveData.value = viewStateLiveData.value?.copy(notes = notes!!) ?: MainViewState(notes!!)
        }
    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData

}