package woowacourse.movie

import java.io.Serializable

data class Ticket(
    val title: String,
    val screeningDate: String,
    val count: Int,
    val price: Int = count * DEFAULT_MOVIE_PRICE,
) : Serializable {
    companion object {
        const val DEFAULT_MOVIE_PRICE = 13_000
    }
}
