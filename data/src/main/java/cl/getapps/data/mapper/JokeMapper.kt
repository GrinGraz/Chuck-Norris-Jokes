package cl.getapps.data.mapper

import cl.getapps.data.model.JokeEntity
import javax.inject.Inject


open class JokeMapper @Inject constructor(): Mapper<JokeEntity, Joke> {
    override fun mapToEntity(type: JokeEntity): {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mapFromEntity(type:): JokeEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}