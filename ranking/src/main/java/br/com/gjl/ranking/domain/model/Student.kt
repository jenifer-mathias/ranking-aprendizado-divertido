package br.com.gjl.ranking.domain.model

data class Student(
    val firstName: String,
    val lastName: String,
    val age: Int?,
    val cellphone: Int?,
    val gradeNumber: Int,
    val gradeLetter: String,
    val score: Int,
    val image: String?
)

