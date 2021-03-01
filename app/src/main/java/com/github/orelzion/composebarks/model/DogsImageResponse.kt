package com.github.orelzion.composebarks.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DogsImageResponse(
    @SerialName("message")
    val imageUrlList: List<String>
)
