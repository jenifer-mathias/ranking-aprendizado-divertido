package br.com.gjl.rankingcore.data.repository

import br.com.gjl.rankingcore.domain.model.Student

interface RankingRepository {
    suspend fun getStudent(): List<Student>
}