package com.philipademba.takehome.domain.moviedetail

import com.philipademba.takehome.data.repository.moviesdetail.MovieDetailRepository
import com.philipademba.takehome.data.repository.moviesdetail.MovieDetailRepositoryImpl
import com.philipademba.takehome.shared.util.AppResource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val movieDetailRepository: MovieDetailRepositoryImpl) {
    suspend operator fun invoke(movieId: Int) = flow {
        try {
            emit(AppResource.loading())
            val dto = movieDetailRepository.fetchMovieDetail(movieId)
            if (dto != null) {
                emit(AppResource.success(dto))
            } else {
                emit(AppResource.error("Not found"))
            }

        } catch (e: Exception) {
            emit(AppResource.error("Unexpected error occurred"))
        }
    }
}