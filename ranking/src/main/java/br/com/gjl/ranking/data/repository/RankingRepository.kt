package br.com.gjl.ranking.data.repository

import br.com.gjl.ranking.domain.model.Student

interface RankingRepository {
    suspend fun getStudent(): List<Student>
}