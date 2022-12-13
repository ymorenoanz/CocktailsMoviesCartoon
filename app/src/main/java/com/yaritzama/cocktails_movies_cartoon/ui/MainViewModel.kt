package com.yaritzama.cocktails_movies_cartoon.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaritzama.cocktails_movies_cartoon.domain.models.MainData
import com.yaritzama.cocktails_movies_cartoon.domain.models.StateViews
import com.yaritzama.cocktails_movies_cartoon.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: MainRepository
) : ViewModel() {

private val _listCartoon = mutableStateListOf<MainData>()
    val listCartoon: SnapshotStateList<MainData>
    get() = _listCartoon

    private val _listCocktail = mutableStateListOf<MainData>()
    val listCocktail: SnapshotStateList<MainData>
        get() = _listCocktail

    var dataList = mutableStateOf<List<MainData>>(listOf())

    private val _listMovie = mutableStateListOf<MainData>()
    val listMovie: SnapshotStateList<MainData>
        get() = _listMovie

    private val _data = mutableStateOf("")
    val data: State<String>
    get() = _data

    private val _containerState = mutableStateOf<StateViews>(StateViews.viewMovie)
    val containerState : State<StateViews>
        get() = _containerState

    init{
        getListCartoon()
        getCocktailByIngredient()
        getListMovie()
    }

    fun switchViews(view: StateViews){
        _containerState.value = view
    }

    private fun getListCartoon(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getCharacterList()
            _listCartoon.addAll(response)
        }
    }

    private fun getListMovie(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getMovieByRegion("mx")
            _listMovie.addAll(response)
        }
    }

    fun getMovieByRegion(region: String){
    }

    //PENDING
    private fun getCocktailByIngredient(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getDrinkByIngredient("sprite")
            _listCocktail.addAll(response)
        }
    }

    private fun getListCocktail(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getDrinkList()
            _listCocktail.addAll(response)
        }
    }



}
