package com.atilsamancioglu.moviedatabasecompose.presentation.movies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.atilsamancioglu.moviedatabasecompose.presentation.Screen
import com.atilsamancioglu.moviedatabasecompose.presentation.movies.MoviesEvent
import com.atilsamancioglu.moviedatabasecompose.presentation.movies.MoviesViewModel

@Composable
fun MovieScreen(
    navController: NavController,
    viewModel : MoviesViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {

        Column() {
            MovieSearchBar(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            hint = "Batman",
                onSearch = {
                    viewModel.onEvent(MoviesEvent.Search(it))
                }
            )

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.movies) { movie ->
                    MovieListRow(movie = movie, onItemClick = {
                        //navigate to details
                        navController.navigate(Screen.MovieDetailScreen.route+"/${movie.imdbID}")
                    })
                }
            }
        }



        if (state.error.isNotBlank()) {
            Text(text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
                    .align(Alignment.Center)
                )
        }

        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }


}

@Composable
fun MovieSearchBar(
    modifier : Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        TextField(
            value = text,
            keyboardActions = KeyboardActions(onDone = {
                onSearch(text)
            }),
            onValueChange = {
                text =it
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White)
        ,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp)
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true && text.isEmpty()
                }
        )
        if(isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}