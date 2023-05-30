package com.harshad.noteapp.localdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {

        private var INSTANCE: NoteDataBase? = null

        fun getDatabase(ctx: Context): NoteDataBase {
            return if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    ctx.applicationContext,
                    NoteDataBase::class.java, "NoteDataBase"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                INSTANCE!!
            } else {
                INSTANCE!!
            }
        }
    }
}