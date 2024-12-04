package com.example.tweetsy.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsy.R
import com.example.tweetsy.models.CategoriesList
import com.example.tweetsy.viewmodels.CategoryViewModel

@Composable
fun CategoryScreen() {
    val categoryViewModel:CategoryViewModel= viewModel()
    val categories: State<List<String>> =categoryViewModel.categories.collectAsState()

    // Apply padding for system bars (status bar, navigation bar)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
    ){
        if (categories.value.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(1f),
                contentAlignment = Alignment.Center
            ) {
                Text("Loading.....", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }
        } else {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(12.dp),

                verticalArrangement = Arrangement.SpaceAround
            ) {
                items(categories.value) {
                    CategoryItem(it)
                }
            }
        }
    }

}

@Composable
fun CategoryItem(category: String) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .width(150.dp)
            .height(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(painterResource(R.drawable.wave), contentScale = ContentScale.Crop)
            .border(1.dp, Color(0xFFEEEEEE)),
            contentAlignment = Alignment.BottomCenter
    ){
        Text(text = category,
            fontSize = 22.sp,
            color = Color.Black,
            modifier = Modifier.padding(0.dp,20.dp),
            style = MaterialTheme.typography.bodySmall

            )
    }
}