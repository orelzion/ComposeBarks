package com.github.orelzion.composebarks.model

class DogsRepository(private val networkService: DogsNetworkService) {
    suspend fun loadDogs(breed: String): Result<DogsImageResponse> {
        return try {
            Result.success(networkService.getDogsImagesList(breed))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}