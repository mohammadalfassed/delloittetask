package com.mohammad.delloittetask.features.news.domain.usecase

import com.mohammad.delloittetask.features.news.domain.repository.NewsRepository
import javax.inject.Inject

class PopularNewsUseCase @Inject constructor(private val repository: NewsRepository) {

    suspend operator fun invoke(period: Int) = repository.getPopularNews(period)
}
