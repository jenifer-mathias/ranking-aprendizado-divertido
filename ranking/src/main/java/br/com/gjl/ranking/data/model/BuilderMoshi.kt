package br.com.gjl.ranking.data.model

import br.com.gjl.ranking.domain.model.Student
import com.squareup.moshi.Moshi

object BuilderMoshi {
    val moshi = Moshi.Builder().build()
    val adaptador = moshi.adapter(Student::class.java)
}