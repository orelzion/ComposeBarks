package com.github.orelzion.composebarks.model

import retrofit2.http.GET
import retrofit2.http.Path

interface DogsNetworkService : DogsService {
    @GET("breed/{breed}/images")
    override suspend fun getDogsImagesList(@Path("breed") breed: String): Result<DogsImageResponse>
}