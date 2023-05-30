package com.harshad.noteapp.adapter

import com.harshad.noteapp.localdata.NoteEntity

interface NoteClickDeleteInterface {

    // creating a method for click
    // action on delete image view.
    fun onDeleteIconClick(note: NoteEntity)
}