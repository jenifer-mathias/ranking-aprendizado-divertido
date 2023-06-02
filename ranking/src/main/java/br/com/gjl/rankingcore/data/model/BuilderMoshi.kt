package br.com.gjl.rankingcore.data.model

import br.com.gjl.rankingcore.domain.model.Student
import com.squareup.moshi.Moshi

object BuilderMoshi {
    val moshi = Moshi.Builder().build()
    val adaptador = moshi.adapter(Student::class.java)
}