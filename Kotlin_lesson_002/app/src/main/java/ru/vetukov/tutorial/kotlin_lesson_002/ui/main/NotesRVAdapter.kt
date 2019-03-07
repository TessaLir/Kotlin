package ru.vetukov.tutorial.kotlin_lesson_002.ui.main

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_note.view.*
import ru.vetukov.tutorial.kotlin_lesson_002.R
import ru.vetukov.tutorial.kotlin_lesson_002.data.entity.Note

class NotesRVAdapter (val onItemClick : ((Note) -> Unit)? = null)
    : RecyclerView.Adapter<NotesRVAdapter.ViewHolder>() {

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

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val titleTextVew = itemView.findViewById<TextView>(R.id.item_tv_title)
        val textTextVew = itemView.findViewById<TextView>(R.id.item_tv_text)

        fun bind(note: Note) = with(note) {
            titleTextVew.text = title
            textTextVew.text = text

            val background = when(color){
                Note.Color.WHITE -> R.color.white
                Note.Color.YELLOW -> R.color.yellow
                Note.Color.GREEN -> R.color.green
                Note.Color.BLUE -> R.color.blue
                Note.Color.RED -> R.color.red
                Note.Color.VIOLET -> R.color.violet
                Note.Color.PINK -> R.color.pink
            }

            itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, background))
            itemView.setOnClickListener {
                onItemClick?.invoke(note)
            }
        }
    }
}