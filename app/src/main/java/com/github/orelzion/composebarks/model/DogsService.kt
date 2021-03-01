package com.github.orelzion.composebarks.model

interface DogsService {
    suspend fun getDogsImagesList(breed: String): Result<DogsImageResponse>
}