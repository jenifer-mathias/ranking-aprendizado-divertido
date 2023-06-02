package br.com.gjl.rankingcore.data.model

import br.com.gjl.rankingcore.domain.model.Student
import com.squareup.moshi.Json

data class StudentResponse(
    @Json(name = "student_first_name") val firstName: String,
    @Json(name = "student_last_name") val lastName: String,
    @Json(name = "student_age") val age: Int?,
    @Json(name = "student_cellphone_number") val cellphone: Int?,
    @Json(name = "student_grade_number") val gradeNumber: Int,
    @Json(name = "student_grade_letter") val gradeLetter: String,
    @Json(name = "student_score") val score: Int,
    @Json(name = "student_image") val image: String?
)

fun StudentResponse.toStudent() = Student(
    firstName = this.firstName,
    lastName = this.lastName,
    age = this.age,
    cellphone = this.cellphone,
    gradeNumber = this.gradeNumber,
    gradeLetter = this.gradeLetter,
    score = this.score,
    image = this.image
)
