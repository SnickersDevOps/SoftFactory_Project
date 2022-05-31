package dts.apps.quiz_app_snickers.REST

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("http://10.201.2.114:9990").addConverterFactory(GsonConverterFactory.create()).build()
    }

    val api : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}