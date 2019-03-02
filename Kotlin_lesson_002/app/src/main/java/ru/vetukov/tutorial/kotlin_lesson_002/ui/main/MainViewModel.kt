package ru.vetukov.tutorial.kotlin_lesson_002.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ru.vetukov.tutorial.kotlin_lesson_002.data.NotesRepository

class MainViewModel: ViewModel() {

    private val viewStateLiveData : MutableLiveData<MainViewState> = MutableLiveData()

    init {
        viewStateLiveData.value = MainViewState(NotesRepository.notes)
    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData

}