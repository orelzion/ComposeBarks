package com.github.orelzion.composebarks.viewmodel

import androidx.lifecycle.*
import com.github.orelzion.composebarks.model.DogsImageResponse
import com.github.orelzion.composebarks.model.DogsRepository
import kotlinx.coroutines.launch

class DogsListViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val dogsRepository: DogsRepository
) : ViewModel() {

    companion object {
        private const val DOGS_LIST_LIVE_DATA = "dogs_list_live_data"
    }

    private val _dogsListLiveData: MutableLiveData<DogsListViewState> =
        savedStateHandle.getLiveData(
            DOGS_LIST_LIVE_DATA, DogsListViewState.Loading(
                DogsListViewData(emptyList())
            )
        )
    val dogsListLiveData: LiveData<DogsListViewState> = _dogsListLiveData
    private var viewState: DogsListViewState
        get() = _dogsListLiveData.value!!
        set(value) {
            _dogsListLiveData.postValue(value)
        }

    init {
        if (viewState.dogsListViewData.dogsImageList.isEmpty()) {
            viewModelScope.launch {
                val result = dogsRepository.loadDogs("hound")

                // In case of success
                result.onSuccess {
                    viewState = DogsListViewState.Loaded(it.toViewData())
                }

                result.onFailure {
                    // TODO error handling
                    viewState = DogsListViewState.Error(viewState.dogsListViewData, it.message ?: "")
                }
            }
        }
    }

    private fun DogsImageResponse.toViewData(): DogsListViewData =
        DogsListViewData(this.imageUrlList)
}