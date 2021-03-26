package castelles.com.github.pokedex.data.service.repository

import castelles.com.github.pokedex.data.service.data.Pokemon
import castelles.com.github.pokedex.data.service.datasource.CharacterDataSource

class CharacterRepository(
    dataSource: CharacterDataSource
): BaseRepository<Pokemon>(dataSource) {



}