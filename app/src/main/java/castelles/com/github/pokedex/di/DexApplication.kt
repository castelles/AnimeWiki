package castelles.com.github.pokedex.di

import android.app.Application
import castelles.com.github.pokedex.util.ExceptionHandler
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DexApplication : Application() {

    private lateinit var exceptionHandler: ExceptionHandler

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@DexApplication)
            modules(
                listOf(
                    appModules,
                    viewModelModules,
                    dataSourceModules,
                    repositoryModules
                )
            )
        }

        exceptionHandler = get()
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler)
    }
}