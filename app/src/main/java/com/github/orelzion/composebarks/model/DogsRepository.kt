package com.github.orelzion.composebarks.model

class DogsRepository(private val networkService: DogsNetworkService) {
    suspend fun loadDogs(breed: String): Result<DogsImageResponse> = networkService.getDogsImagesList(breed)
}