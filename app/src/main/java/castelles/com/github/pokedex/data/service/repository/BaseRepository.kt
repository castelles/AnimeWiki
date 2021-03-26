package castelles.com.github.pokedex.data.service.repository

import castelles.com.github.pokedex.data.service.datasource.BaseDataSource
import retrofit2.Call
import rx.Subscriber


abstract class BaseRepository<T>(protected open val dataSource : BaseDataSource)
{
    protected fun <T> callResponse(
        callResponse: Call<T>,
        c: Subscriber<in T>
    ) {
        val response = callResponse.execute()

        if (response.isSuccessful) {
            val dataResponse = response.body()
            c.onNext(dataResponse)
            c.onCompleted()
        } else {

            var t = Throwable(message =  response.errorBody()?.string(), cause = Throwable(response.code().toString()))
            c.onError(t)
        }
    }
}