package com.harshad.noteapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.harshad.noteapp.R
import com.harshad.noteapp.adapter.NoteAdapter
import com.harshad.noteapp.adapter.NoteClickDeleteInterface
import com.harshad.noteapp.adapter.NoteClickInterface
import com.harshad.noteapp.databinding.ActivityMainBinding
import com.harshad.noteapp.localdata.NoteEntity
import com.harshad.noteapp.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity(), NoteClickInterface, NoteClickDeleteInterface {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerview()
        initViewModel()
    }

    private fun initViewModel() {
        noteViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[NoteViewModel::class.java]
        noteViewModel.noteList.observe(this) { list ->
            list?.let {
                noteAdapter.updatedList(it as ArrayList)
            }
        }
    }

    private fun initRecyclerview() {
        noteAdapter = NoteAdapter(this, this, this)
        binding.rvNotes.layoutManager = LinearLayoutManager(this)
        binding.rvNotes.adapter = noteAdapter

        binding.faAdd.setOnClickListener {
            Toast.makeText(this, "we are working on this feature", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDeleteIconClick(note: NoteEntity) {
        noteViewModel.deleteNote(note)
        Toast.makeText(this, "${note.noteTitle} Deleted", Toast.LENGTH_LONG).show()
    }

    override fun onNoteClick(note: NoteEntity) {
        //
    }

}