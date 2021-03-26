package castelles.com.github.pokedex.data.service.datasource

import castelles.com.github.pokedex.BuildConfig
import castelles.com.github.pokedex.data.service.BigDecimalAdapter
import com.squareup.moshi.Moshi
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

abstract class BaseDataSource(url: String? = null)
{
    protected val serviceUrl : String? = url
    protected lateinit var retrofit : Retrofit

    companion object {
        private val TIMEOUT_CONNECTION_SECONDS: Long = 200
    }

    init {
        build()
    }

    protected open  fun build() {

        val moshi = Moshi.Builder()
            .add(BigDecimalAdapter)
            .build()

        val loggin = HttpLoggingInterceptor()
        loggin.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client: OkHttpClient.Builder = OkHttpClient().newBuilder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)

        client.addInterceptor {

            val builder = it
                .request()
                .newBuilder()
                .build()

            it.proceed(builder)
        }

        client.addInterceptor(loggin)

        retrofit = Retrofit.Builder()
            .baseUrl(serviceUrl ?: BuildConfig.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .client(client.build())
            .build()
    }

}