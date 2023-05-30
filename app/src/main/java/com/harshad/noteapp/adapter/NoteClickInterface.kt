package com.harshad.noteapp.adapter

import com.harshad.noteapp.localdata.NoteEntity

interface NoteClickInterface {
    // creating a method for click action
    // on recycler view item for updating it.
    fun onNoteClick(note: NoteEntity)
}