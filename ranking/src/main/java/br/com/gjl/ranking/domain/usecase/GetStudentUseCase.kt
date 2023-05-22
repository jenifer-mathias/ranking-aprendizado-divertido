package br.com.gjl.ranking.domain.usecase

import br.com.gjl.ranking.data.repository.RankingRepository
import br.com.gjl.ranking.domain.model.Student

sealed class GetStudentResult {
    data class Success(val students: List<Student>) : GetStudentResult()
    data class Error(val exception: Exception) : GetStudentResult()
}

class GetStudentUseCase(private val rankingRepository: RankingRepository) {
    suspend operator fun invoke(): GetStudentResult = try {
        GetStudentResult.Success(orderedStudentByDescendingScore(rankingRepository))
    } catch (ex: Exception) {
        GetStudentResult.Error(ex)
    }
}

private suspend fun orderedStudentByDescendingScore(rankingRepository: RankingRepository) =
    rankingRepository.getStudent().sortedWith(compareByDescending<Student> { it.score }
        .thenBy { it.firstName }
        .thenBy { it.lastName }
    )

