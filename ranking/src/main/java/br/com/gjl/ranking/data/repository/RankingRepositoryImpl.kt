package br.com.gjl.ranking.data.repository

import br.com.gjl.ranking.data.api.RankingApi
import br.com.gjl.ranking.data.model.toStudent
import br.com.gjl.ranking.domain.model.Student

class RankingRepositoryImpl(private val service: RankingApi) : RankingRepository {

    override suspend fun getStudent(): List<Student> {

        return try {
            val studentResponseList = service.getStudents()
            studentResponseList.map { it.toStudent() }
        } catch (ex: Exception) {
            throw Exception("Failed to fetch students")
        }
    }
}