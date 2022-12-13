package com.yaritzama.cocktails_movies_cartoon.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yaritzama.cocktails_movies_cartoon.domain.models.StateViews
import com.yaritzama.cocktails_movies_cartoon.ui.theme.Cocktails_Movies_CartoonTheme
import com.yaritzama.cocktails_movies_cartoon.ui.views.CartoonScreen
import com.yaritzama.cocktails_movies_cartoon.ui.views.CocktailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cocktails_Movies_CartoonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val vm: MainViewModel = viewModel()

                    Column(modifier = Modifier.fillMaxSize()) {
                        Header(modifier = Modifier.fillMaxWidth(), vm = vm)
                        Body(modifier = Modifier.fillMaxSize(), vm)
                    }
                }
            }
        }
    }
}


@Composable
fun Tabs(modifier: Modifier = Modifier,
         title: String, isSelected : Boolean,
         onClick : () -> Unit)
{
    Box(modifier = modifier
        .clickable {
            onClick.invoke()
        }
        .background(
            if (isSelected) Color.Black
            else Color(0xff1E76DA)
        )
        .height(60.dp)
        .padding(vertical = 4.dp, horizontal = 8.dp)
        .padding(4.dp)) {
        Text(text = title, modifier = Modifier.align(Alignment.Center)
            , color = Color.White)
    }
}

@Composable
private fun Header(modifier: Modifier= Modifier, vm: MainViewModel) {

    val viewState = remember { vm.containerState }

    Row(modifier = modifier) {
        Tabs(title = "Movies", modifier = Modifier
            .weight(1f)
            .background(Color.White),
            isSelected = viewState.value == StateViews.viewMovie
        ) {
            vm.switchViews(StateViews.viewMovie)
        }
        Tabs(title = "Cartoon", modifier = Modifier
            .weight(1f)
            .background(Color.White),
            isSelected = viewState.value == StateViews.viewCartoon) {
            vm.switchViews(StateViews.viewCartoon)
        }

        Tabs(title = "Cocktail", modifier = Modifier
            .weight(1f)
            .background(Color.White),
            isSelected = viewState.value == StateViews.viewCocktails) {
            vm.switchViews(StateViews.viewCocktails)
        }
    }
}


@Composable
private fun Body(modifier: Modifier= Modifier, vm: MainViewModel) {

    val viewState = remember { vm.containerState }

    Box(modifier = modifier) {
        when(viewState.value){
            StateViews.viewMovie -> {
                MovieScreen()
            }
            StateViews.viewCartoon -> {
                CartoonScreen()
            }

            StateViews.viewCocktails ->{
                CocktailScreen()
            }
        }
    }
}

