package br.com.gjl.rankingcore.data.model

import br.com.gjl.rankingcore.data.api.RankingApi
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//object RetrofitService {
//    private val moshi = Moshi.Builder().build()
//
//    private val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl("http://localhost:8081/")
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .build()
//    }
//
//    val service: RankingApi by lazy {
//        retrofit.create(RankingApi::class.java)
//    }
//}

object RetrofitService {
    private val moshi = Moshi.Builder().build()

    private val retrofit: Retrofit by lazy {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8081/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val service: RankingApi by lazy {
        retrofit.create(RankingApi::class.java)
    }
}