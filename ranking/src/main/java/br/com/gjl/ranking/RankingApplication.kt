package br.com.gjl.ranking

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RankingApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@RankingApplication)
            modules(listOf(rankingServiceModule))
        }
    }
}

