package com.harshad.noteapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harshad.noteapp.databinding.ItemLayoutBinding
import com.harshad.noteapp.localdata.NoteEntity

class NoteAdapter(
    val ctx: Context, val noteClickDeleteInterface: NoteClickDeleteInterface,
    val noteClickInterface: NoteClickInterface
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    var allNotes = ArrayList<NoteEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.setData(allNotes[position], position)
    }

    inner class NoteViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(noteEntity: NoteEntity, pos: Int) {
            binding.tvNoteTitle.text = noteEntity.noteTitle
            binding.tvDesc.text = noteEntity.noteDescription

            binding.imgDelete.setOnClickListener {
                noteClickDeleteInterface.onDeleteIconClick(allNotes[pos])
            }
            binding.clyEdit.setOnClickListener {
                noteClickInterface.onNoteClick(allNotes[pos])
            }
        }
    }

    fun updatedList(notes: ArrayList<NoteEntity>) {
        allNotes = notes
        notifyDataSetChanged()
    }
}
