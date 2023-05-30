package com.harshad.noteapp

import androidx.lifecycle.LiveData
import com.harshad.noteapp.localdata.NoteDao
import com.harshad.noteapp.localdata.NoteEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteRepository(private val noteDao: NoteDao) {

    fun getALlNotes(): LiveData<List<NoteEntity>> {
        return noteDao.getAllNotes()
    }

    fun addNote(note: NoteEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.insert(note)
        }
    }

    fun deleteNote(note: NoteEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.delete(note)
        }
    }

    fun updateNote(note: NoteEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.updateNote(note)
        }
    }


}