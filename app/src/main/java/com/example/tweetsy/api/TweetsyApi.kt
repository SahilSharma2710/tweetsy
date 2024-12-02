package com.example.tweetsy.api

import com.example.tweetsy.models.CategoriesList
import com.example.tweetsy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TweetsyApi {

    @GET("/v3/b/673c4550ad19ca34f8cc7781?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String):Response<List<TweetListItem>>

    @GET("/v3/b/674d51acacd3cb34a8b26cd4?meta=false")
    suspend fun getCategories() : Response<CategoriesList>
}