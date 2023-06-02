package br.com.gjl.rankingcore.data.api

import br.com.gjl.rankingcore.data.model.StudentResponse
import retrofit2.http.GET

interface RankingApi {
    @GET("/student")
    suspend fun getStudents(): List<StudentResponse>
}