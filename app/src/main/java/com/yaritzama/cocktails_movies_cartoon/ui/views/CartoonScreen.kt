package com.yaritzama.cocktails_movies_cartoon.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CartoonScreen(){
    val vm: MainViewModel = hiltViewModel()
    val cartoon = vm.listCartoon

    Column(modifier = Modifier.padding(8.dp)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(cartoon) { item->
                    Card(elevation = 8.dp, modifier =
                    Modifier.padding(8.dp)){
                        Column(
                            Modifier.padding(16.dp)) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = item.name.toString(),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Left
                            )
                            Box(modifier = Modifier
                                .height(100.dp)
                                .width(100.dp)){
                                GlideImage(imageModel = {"https://rickandmortyapi.com/api/character/avatar/" +
                                        "${item.id}.jpeg"})
                            }
                        }
                    }
                }
            })
    }
}