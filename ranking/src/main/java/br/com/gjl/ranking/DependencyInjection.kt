package br.com.gjl.ranking

import br.com.gjl.ranking.data.model.RetrofitService
import br.com.gjl.ranking.data.repository.RankingRepository
import br.com.gjl.ranking.data.repository.RankingRepositoryImpl
import br.com.gjl.ranking.domain.usecase.GetStudentUseCase
import br.com.gjl.ranking.presenter.RankingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val rankingServiceModule = module {

    single { RetrofitService.service }

    single<RankingRepository> { RankingRepositoryImpl(get()) }

    single { GetStudentUseCase(get()) }

    viewModel { RankingViewModel(get()) }
}