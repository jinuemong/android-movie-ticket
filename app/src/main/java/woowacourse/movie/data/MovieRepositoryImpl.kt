package woowacourse.movie.data

import woowacourse.movie.R
import woowacourse.movie.domain.model.Movie
import woowacourse.movie.domain.repository.MovieRepository

class MovieRepositoryImpl : MovieRepository {
    override fun loadMovies(): List<Movie> {
        return MockMovies.sampleMovies
    }

    override fun getMovie(id: Int): Movie {
        return MockMovies.sampleMovies.find { movie: Movie ->
            movie.movieId == id
        } ?: MockMovies.defaultMovie
    }
}
