package com.example.tweetsy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsy.models.CategoriesList
import com.example.tweetsy.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: TweetRepository):ViewModel()  {
    val categories:StateFlow<CategoriesList>
        get() = repository.categories

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }
}