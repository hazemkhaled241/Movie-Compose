package com.hazem.movie_app.presentation.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.movie_app.data.paging.PaginationFactory
import com.hazem.movie_app.domain.use_case.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {
    private val _screenState = mutableStateOf(ScreenState())
    val screenState: State<ScreenState> = _screenState

    private val pagination = PaginationFactory(
        initialKey = _screenState.value.page,
        onLoading = {
            _screenState.value = _screenState.value.copy(isLoading = it)
        },
        onRequest = {nextPage->
            homeUseCase(nextPage)
        },
        onSuccess = { items, newPage ->
            _screenState.value=_screenState.value.copy(
                data = _screenState.value.data + items.movies,
                page = newPage,
                endReached = _screenState.value.page == 25
            )
        },
        onError = {

        },
        getNextKey = {
            _screenState.value.page+1
        }
    )

    init {
        getAllMovies()
    }

    private fun getAllMovies() {
        viewModelScope.launch {
            /*try {
                homeUseCase(_screenState.value.page).let { response ->
                    when (response.isSuccessful) {
                        true -> {
                            _screenState.value = ScreenState(data = response.body()!!.movies)
                        }

                        false -> {
                            _screenState.value =
                                ScreenState(error = response.errorBody().toString())
                        }
                    }
                }
            } catch (e: Exception) {
                _screenState.value = ScreenState(error = e.localizedMessage)

            }*/
            pagination.loadNextPage()

        }
    }
}