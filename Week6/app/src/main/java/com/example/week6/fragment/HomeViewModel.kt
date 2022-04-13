package com.example.week6.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week6.model.Movie
import com.example.week6.service.MovieRestClient
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private var _movieData: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    val movieData: LiveData<List<Movie>>
        get() = _movieData

    fun getNowPlaying() {
        viewModelScope.launch {
            val movieResp = MovieRestClient.getInstance().api.listNowPlayMovies(
                language = "en-US",
                page = 1
            )

            _movieData.postValue(movieResp.results!!)
        }
    }

    fun getComingUpMovie() {
        viewModelScope.launch {
            val movieResp =
                MovieRestClient.getInstance().api.listUpComingMovies(
                    language = "en-US",
                    page = 1
                )

            _movieData.postValue(movieResp.results!!)
        }
    }
}