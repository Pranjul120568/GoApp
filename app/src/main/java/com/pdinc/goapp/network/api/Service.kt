package com.pdinc.goapp.network.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    private val okHttpClient=OkHttpClient.Builder()
        .addInterceptor { chain ->
        val request=chain.request()
            .newBuilder()
            .addHeader("x-rapidapi-key", "")
            .addHeader("x-rapidapi-host", "")
            .build()
            chain.proceed(request)
        }
        .build()
    private fun getRetrofitForTripAdvisor(URL : String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
           // .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }
    val tripAdvisorApiService: TripAdvisorApiServices =
        getRetrofitForTripAdvisor("https://tripadvisor1.p.rapidapi.com/").create(TripAdvisorApiServices::class.java)
}
//imp. link
//https://futurestud.io/tutorials/retrofit-add-custom-request-header
