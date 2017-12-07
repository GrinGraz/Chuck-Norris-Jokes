package cl.getapps.data.mapper

import cl.getapps.data.model.JokeEntity
import cl.getapps.domain.model.Joke
import javax.inject.Inject


open class JokeMapper @Inject constructor(): Mapper<JokeEntity, Joke> {

    override fun mapFromEntity(type: JokeEntity): Joke {
        return Joke(type.category, type.icon_url, type.id, type.url, type.value)
    }

    override fun mapToEntity(type: Joke): JokeEntity{
        return JokeEntity(type.category, type.icon_url, type.id, type.url, type.value)
    }
}
