package com.mohammad.delloittetask.features.news.presentation.newslist

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammad.delloittetask.features.news.domain.models.NewsListModel
import com.mohammad.delloittetask.features.news.domain.usecase.PopularNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val popularNewsUseCase: PopularNewsUseCase,
) : ViewModel(), LifecycleObserver {

    private val _progressSharedFlow = MutableSharedFlow<Boolean>()
    val progressSharedFlow: SharedFlow<Boolean> = _progressSharedFlow

    private val _successGetNewsSharedFlow = MutableSharedFlow<List<NewsListModel>?>()
    val successGetNewsSharedFlow = _successGetNewsSharedFlow.asSharedFlow()

    private val _errorSharedFlow = MutableSharedFlow<Throwable?>()
    val errorSharedFlow: SharedFlow<Throwable?> = _errorSharedFlow


    fun getPopularNews(period: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _progressSharedFlow.emit(true)
            try {
                popularNewsUseCase(period).let {
                    _successGetNewsSharedFlow.emit(it)
                }
            } catch (e: Throwable) {
                _errorSharedFlow.emit(e)
            }
            _progressSharedFlow.emit(false)
        }
    }

    fun navigateToNewsDetails(currentFragment: Fragment) {
//        navFromLoginToRegisterUseCase(
//            currentFragment = currentFragment
//        )
    }
}