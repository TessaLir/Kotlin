package ru.vetukov.tutorial.kotlin_lesson_002.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_note.view.*
import ru.vetukov.tutorial.kotlin_lesson_002.R
import ru.vetukov.tutorial.kotlin_lesson_002.data.entity.Note

class NotesRVAdapter: RecyclerView.Adapter<NotesRVAdapter.ViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_note,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(notes[position])

    override fun getItemCount() = notes.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(note: Note) = with(itemView) {
            item_tv_title.text = note.title
            item_tv_text.text = note.text
            itemView.setBackgroundColor(note.color)
//            Picasso
//                .with(this.context)
//                .load(note.picture)
//                .fit()
//                .centerCrop()
//                .into(item_picture)
        }
    }
}