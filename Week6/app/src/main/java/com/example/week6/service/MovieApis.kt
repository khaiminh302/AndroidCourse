package com.example.week6.service

import com.example.week6.model.MovieResp
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApis {

    @GET("movie/now_playing")
    suspend fun listNowPlayMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): MovieResp


    @GET("movie/upcoming")
    suspend fun listUpComingMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MovieResp


    @GET("movie/top_rated")
    suspend fun listTopRateMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MovieResp

}