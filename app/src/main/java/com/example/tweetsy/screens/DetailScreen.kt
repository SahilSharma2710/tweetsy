package com.example.tweetsy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsy.viewmodels.DetailViewModel

@Composable
fun DetailScreen() {
     val detailViewModel:DetailViewModel= viewModel()
     val tweets=detailViewModel.tweets.collectAsState()

     Box(
         modifier = Modifier
             .padding(WindowInsets.systemBars.asPaddingValues())
             .fillMaxSize()
     ){
         LazyColumn {
             items(tweets.value) {
                 TweetListItem(it.text)
             }
         }
     }
}

@Composable
fun TweetListItem(tweet:String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp,),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),

    ) {
        Text(
            text = tweet,
            fontSize = 19.sp,
            modifier = Modifier.padding(16.dp,24.dp),style= MaterialTheme.typography.bodyMedium,
            )
    }
}