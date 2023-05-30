package com.harshad.noteapp.localdata

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    // adding a new entry to our database.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note :NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)

    // below is the method to read all the notes
    // from our database we have specified the query for it.
    // inside the query we are arranging it in ascending
    // order on below line and we are specifying
    // the table name from which
    // we have to get the data.
    @Query("Select * from noteTable order by id ASC")
    fun getAllNotes(): LiveData<List<NoteEntity>>

    @Update
    suspend fun updateNote(note :NoteEntity)
}