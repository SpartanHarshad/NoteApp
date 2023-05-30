package com.harshad.noteapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.harshad.noteapp.NoteRepository
import com.harshad.noteapp.localdata.NoteDataBase
import com.harshad.noteapp.localdata.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val noteList: LiveData<List<NoteEntity>>
    val repository: NoteRepository

    init {
        val dao = NoteDataBase.getDatabase(application).getNoteDao()
        repository = NoteRepository(dao)
        noteList = repository.getALlNotes()
    }

    fun deleteNote(note: NoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(note)
        }
    }

    fun updateNote(note: NoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNote(note)
        }
    }

    fun addNote(note: NoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(note)
        }
    }
}