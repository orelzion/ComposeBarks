package com.github.orelzion.composebarks.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.github.orelzion.composebarks.viewmodel.DogsListViewModel
import com.github.orelzion.composebarks.viewmodel.DogsListViewState

@Composable
fun DogListScreen(vm: DogsListViewModel, onItemClicked: (String) -> Unit) {
    val viewState by vm.dogsListLiveData.observeAsState()

    when (viewState) {
        is DogsListViewState.Loading, null -> Loader()
        is DogsListViewState.Error -> ErrorState(errorMessage = (viewState as DogsListViewState.Error).errorMessage)
        is DogsListViewState.Loaded -> ImageList(
            items = viewState?.dogsListViewData?.dogsImageList ?: emptyList(),
            onItemClicked = onItemClicked
        )
    }
}

@Composable
fun Loader() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorState(errorMessage: String) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = errorMessage)
    }
}

@Composable
fun ImageList(items: List<String>, onItemClicked: (String) -> Unit) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(items = items) { dogImage ->
            DogImage(url = dogImage, onItemClicked = onItemClicked)
            Divider(modifier = Modifier.height(4.dp), color = Color.Transparent)
        }
    }
}

@Composable
fun DogImage(url: String, onItemClicked: (String) -> Unit) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(4.dp))
        .clickable { onItemClicked.invoke(url) }) {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = null,
            modifier = Modifier
                .height(320.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDogList() {
    ImageList(items = listOf(
        "https://picsum.photos/200/300"
    ), onItemClicked = {})
}