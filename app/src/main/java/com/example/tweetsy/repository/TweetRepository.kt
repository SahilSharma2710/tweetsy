package com.example.tweetsy.repository

import com.example.tweetsy.api.TweetsyApi
import com.example.tweetsy.models.CategoriesList
import com.example.tweetsy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyApi: TweetsyApi) {

    private val _categories= MutableStateFlow<CategoriesList>(CategoriesList(emptyList() ))

    val categories:StateFlow<CategoriesList>
        get() = _categories

    private val _tweets= MutableStateFlow<List<TweetListItem>>(emptyList() )

    val tweets:StateFlow<List<TweetListItem>>
        get() = _tweets

    suspend fun getCategories(){
        val response= tweetsyApi.getCategories()
        if(response.isSuccessful && response.body()!=null){
           _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String){
        val response= tweetsyApi.getTweets(category)
        if(response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)
        }
    }
}