package br.com.gjl.ranking.data.api

import br.com.gjl.ranking.data.model.StudentResponse
import retrofit2.http.GET

interface RankingApi {
    @GET("/student")
    suspend fun getStudents(): List<StudentResponse>
}