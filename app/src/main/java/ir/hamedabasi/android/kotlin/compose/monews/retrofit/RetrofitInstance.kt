package ir.hamedabasi.android.kotlin.compose.monews.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // base news url
    private val BASE_URL = "https://newsapi.org/v2/"

    val api: ApiService by lazy {
        // lazy means, this block wont be executed unless api called for the first time
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(api::class.java)
    }
}