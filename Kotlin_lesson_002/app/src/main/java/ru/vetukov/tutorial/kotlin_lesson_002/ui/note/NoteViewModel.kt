package ru.vetukov.tutorial.kotlin_lesson_002.ui.note

import android.arch.lifecycle.ViewModel
import ru.vetukov.tutorial.kotlin_lesson_002.data.NotesRepository
import ru.vetukov.tutorial.kotlin_lesson_002.data.entity.Note

class NoteViewModel (private val repository: NotesRepository = NotesRepository)
    : ViewModel() {

    private var pendingNote: Note? = null

    fun save (note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let {
            repository.saveNote(it)
        }
    }
}