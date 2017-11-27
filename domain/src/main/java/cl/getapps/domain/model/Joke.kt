package cl.getapps.domain.model


data class Joke(val category: List<String>,
                val icon_url: String,
                val id: String,
                val url: String,
                val value: String)