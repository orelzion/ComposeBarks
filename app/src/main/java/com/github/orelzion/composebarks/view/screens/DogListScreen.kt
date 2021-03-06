package com.github.orelzion.composebarks.view.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.orelzion.composebarks.viewmodel.DogsListViewModel
import com.github.orelzion.composebarks.viewmodel.DogsListViewState
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun DogListScreen(vm: DogsListViewModel, onItemClicked: (String) -> Unit) {
    val viewState by vm.dogsListLiveData.observeAsState()

    when (viewState) {
        is DogsListViewState.Error -> TODO()
        is DogsListViewState.Loaded -> imageList(
            items = viewState?.dogsListViewData?.dogsImageList ?: emptyList(),
            onItemClicked = onItemClicked
        )
        is DogsListViewState.Loading -> loader()
    }
}

@Composable
fun loader() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator()
    }
}

@Composable
fun imageList(items: List<String>, onItemClicked: (String) -> Unit) {
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
        GlideImage(
            data = url,
            contentDescription = null,
            loading = {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDogList() {

}