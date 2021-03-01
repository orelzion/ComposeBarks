package com.github.orelzion.composebarks.viewmodel

sealed class DogsListViewState {
    abstract val dogsListViewData: DogsListViewData

    data class Loading(override val dogsListViewData: DogsListViewData) : DogsListViewState()
    data class Loaded(override val dogsListViewData: DogsListViewData) : DogsListViewState()
    data class Error(override val dogsListViewData: DogsListViewData, val errorMessage: String) :
        DogsListViewState()
}

data class DogsListViewData(
    val dogsImageList: List<String>
)
