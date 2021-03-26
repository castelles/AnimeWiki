package castelles.com.github.pokedex.util

import io.reactivex.ObservableTransformer
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.android.schedulers.AndroidSchedulers.mainThread
import rx.schedulers.Schedulers
import rx.schedulers.Schedulers.io

object RxObserver {

    fun <T> applyStandardObservable(): Observable.Transformer<T, T> =
        Observable.Transformer {
            it
                .subscribeOn(io())
                .observeOn(mainThread())
        }
}