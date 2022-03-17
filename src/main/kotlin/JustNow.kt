package ru.netology

fun main() {
    val time = 1_900_000
    val text = agoToText(time)
    println("Пользователь был(а) $text")

}

fun agoToText(time: Int): String {
    val minutes = time / 60
    val hours = minutes / 60
    val days = hours / 24
    val textHours: String = textConvert(hours, "час")
    val textMinutes: String = textConvert(minutes, "минута")
    val totalTime = if (days >= 1)
        when (days) {
            2 -> "вчера"
            1 -> "сегодня"
            else -> "давно"
        } else if (hours >= 1) "$hours $textHours" else if (minutes >= 1) "$minutes $textMinutes" else "недавно"
    return totalTime
}

fun textConvert(time: Int, dim: String): String {
    val text = when(time % 10) {
        1 -> if (time != 11) {
            if (dim == "час") "час назад" else "минуту назад"
        } else if (dim == "час") "часов назад" else "минут назад"
        2, 3, 4 -> if (dim == "час") "часа назад" else "минуты назад"
        else -> if (dim == "час") "часов назад" else "минут назад"
    }
    return text
}


