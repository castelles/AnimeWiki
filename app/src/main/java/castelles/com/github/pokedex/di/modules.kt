package castelles.com.github.pokedex.di

import castelles.com.github.pokedex.data.service.datasource.CharacterDataSource
import castelles.com.github.pokedex.data.service.repository.CharacterRepository
import castelles.com.github.pokedex.util.ExceptionHandler
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val appModules = module {
    single { ExceptionHandler(androidApplication()) }
}

val viewModelModules = module {

}

val dataSourceModules = module {
    single { CharacterDataSource() }
}

val repositoryModules = module {
    single { CharacterRepository(get()) }
}