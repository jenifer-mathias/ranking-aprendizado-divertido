package br.com.gjl.rankingcore

import br.com.gjl.rankingcore.data.model.RetrofitService
import br.com.gjl.rankingcore.data.repository.RankingRepository
import br.com.gjl.rankingcore.data.repository.RankingRepositoryImpl
import br.com.gjl.rankingcore.domain.usecase.GetStudentUseCase
import br.com.gjl.rankingcore.presenter.RankingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val rankingServiceModule = module {

    single { RetrofitService.service }

    single<RankingRepository> { RankingRepositoryImpl(get()) }

    single { GetStudentUseCase(get()) }

    viewModel { RankingViewModel(get()) }
}