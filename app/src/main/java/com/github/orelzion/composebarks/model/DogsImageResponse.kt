package com.github.orelzion.composebarks.model

import kotlinx.serialization.SerialName

data class DogsImageResponse(
    @SerialName("message")
    val imageUrlList: List<String>
)
