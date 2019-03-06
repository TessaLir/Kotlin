package ru.vetukov.tutorial.kotlin_lesson_002.data

import ru.vetukov.tutorial.kotlin_lesson_002.data.entity.Note

object NotesRepository {

    val notes = listOf(
        Note(
            "Первая заметка",
            "Текст первой заметки. Не очень длинный, но интересный",
            0xfff06292.toInt()
        ),
        Note(
            "Вторая заметка",
            "Текст второй заметки. Не очень длинный, но интересный",
            0xff9575cd.toInt()
        ),
        Note(
            "Третья заметка",
            "Текст третьей заметки. Не очень длинный, но интересный",
            0xff64b5f6.toInt()
        ),
        Note(
            "Четвертая заметка",
            "Текст четвертой заметки. Не очень длинный, но интересный",
            0xff4db6ac.toInt()
        ),
        Note(
            "Пятая заметка",
            "Текст пятой заметки. Не очень длинный, но интересный",
            0xffb2ff59.toInt()
        ),
        Note(
            "Шестая заметка",
            "Текст шестой заметки. Не очень длинный, но интересный",
            0xffffeb3b.toInt()
        )
    )
}