package com.hazem.movie_app.presentation.screen.details

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazem.movie_app.domain.use_case.DetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailsUseCase: DetailsUseCase
) : ViewModel() {
    var movieId by mutableIntStateOf(0)
    private val _movieDetailsState = mutableStateOf(DetailsState())
    val movieDetailsState: State<DetailsState> = _movieDetailsState



     fun getMovieDetails(id: Int) {
        viewModelScope.launch {
            try {


                detailsUseCase(id).let { response ->
                    when (response.isSuccessful) {
                        true -> {
                            _movieDetailsState.value = DetailsState(data = response.body()!!)
                        }

                        false -> {
                            _movieDetailsState.value =
                                DetailsState(error = response.errorBody().toString())
                        }
                    }

                }
            } catch (e: Exception) {
                _movieDetailsState.value =
                    DetailsState(error = e.localizedMessage)
            }
        }
    }
}