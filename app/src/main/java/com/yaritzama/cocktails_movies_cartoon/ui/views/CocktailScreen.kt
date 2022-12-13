package com.yaritzama.cocktails_movies_cartoon.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.skydoves.landscapist.glide.GlideImage
import com.yaritzama.cocktails_movies_cartoon.ui.MainViewModel

@Composable
fun CocktailScreen(){

    val vm: MainViewModel = hiltViewModel()
    val cocktail = vm.listCocktail

    Column(modifier = Modifier.padding(8.dp)) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(cocktail) { item->
                    Card(elevation = 8.dp, modifier =
                    Modifier.padding(8.dp)){
                        Column(
                            Modifier.padding(16.dp)) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = item.strDrink.toString(),
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

fun DropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    offset: DpOffset = DpOffset(0.dp, 0.dp),
    properties: PopupProperties = PopupProperties(focusable = true),
    content: @Composable ColumnScope.() -> Unit
){}

@Composable
fun DropDown(){
    val vm: MainViewModel = hiltViewModel()
    val cocktail = vm.dataList.value
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Light Rum", "Applejack",
        "Gin", "Dark rum", "Tequila", "Sprite")
    val disabledValue = "B"
    var selectedIndex by remember { mutableStateOf(0) }

    Box(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.TopStart)){
        Text(items[selectedIndex],
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
                .background(Color.Gray))
        DropdownMenu(expanded = expanded,
            onDismissRequest = {expanded = false},
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.Red
                )){
            items.forEachIndexed{ index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false}) {
                    val disableText = if(s == disabledValue){
                        "(Disabled)"
                    } else {
                        ""
                    }
                    Text(text = s + disableText)
                }
            }
        }

    }
}