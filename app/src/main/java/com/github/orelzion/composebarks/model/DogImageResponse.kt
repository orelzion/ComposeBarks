package com.github.orelzion.composebarks.model

import kotlinx.serialization.SerialName

data class DogImageResponse(
    @SerialName("message")
    val imageUrlList: List<String>
)
