package cl.getapps.data.model

/**
 * Representation for a [JokeEntity] fetched from an external layer data source
 */
data class JokeEntity(val category: List<String>,
                      val icon_url: String,
                      val id: String,
                      val url: String,
                      val value: String)