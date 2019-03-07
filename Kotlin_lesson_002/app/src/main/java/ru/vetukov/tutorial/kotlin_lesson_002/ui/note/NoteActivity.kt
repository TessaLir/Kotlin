package ru.vetukov.tutorial.kotlin_lesson_002.ui.note

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_note.*
import ru.vetukov.tutorial.kotlin_lesson_002.R
import ru.vetukov.tutorial.kotlin_lesson_002.data.entity.Note
import java.text.SimpleDateFormat
import java.util.*

class NoteActivity : AppCompatActivity() {

    private var note: Note? = null
    lateinit var  viewModel: NoteViewModel

    companion object {
        private val EXTRA_NOTE = NoteActivity::class.java.name + "extra.NOTE"
        private const val DATE_FORMAT = "dd.MM.yy HH:mm"
        private const val SAVE_DELAY = 500L

        fun start(context: Context, note:Note? = null) {
            val intent = Intent(context, NoteActivity::class.java)
            intent.putExtra(EXTRA_NOTE, note)
            context.startActivity(intent)
        }
    }

    val textChangeWather = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            saveNote()
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        note = intent.getParcelableExtra(EXTRA_NOTE)
        setSupportActionBar(note_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)


        supportActionBar?.title = if (note != null) {
            SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(note!!.lastChanged)
        } else {
            getString(R.string.new_note)
        }

        initView()
    }

    private fun initView() {
        note?.let {
            note_et_title.setText(it.title)
            note_et_body.setText(it.text)
            val background = when(it.color) {
                Note.Color.WHITE -> R.color.white
                Note.Color.YELLOW -> R.color.yellow
                Note.Color.GREEN -> R.color.green
                Note.Color.BLUE -> R.color.blue
                Note.Color.RED -> R.color.red
                Note.Color.VIOLET -> R.color.violet
                Note.Color.PINK -> R.color.pink
            }
            note_toolbar.setBackgroundColor(ContextCompat.getColor(this, background))
        }

        note_et_title.addTextChangedListener(textChangeWather)
        note_et_body.addTextChangedListener(textChangeWather)
    }

    private fun saveNote() {
        if (note_et_title.text.isNullOrBlank() || note_et_title.text!!.length < 3) return

        Handler().postDelayed( {
            note = note?.copy(
                title = note_et_title.text.toString(),
                text = note_et_body.text.toString(),
                lastChanged = Date()
            ) ?: Note(
                UUID.randomUUID().toString(),
                note_et_title.text.toString(),
                note_et_body.text.toString()
            )

            note?.let { viewModel.save(note!!) }

        }, SAVE_DELAY)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
