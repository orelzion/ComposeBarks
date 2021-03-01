package com.github.orelzion.composebarks.model

class DogsRepository(private val service: DogsService) {
    suspend fun loadDogs(breed: String): Result<DogImageResponse> = service.getDogsImagesList(breed)
}