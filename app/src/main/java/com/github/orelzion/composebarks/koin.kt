package com.github.orelzion.composebarks

import com.github.orelzion.composebarks.model.DogsNetworkService
import com.github.orelzion.composebarks.model.DogsRepository
import com.github.orelzion.composebarks.model.RetrofitCreator
import org.koin.dsl.module

val appModule = module {
    single { DogsRepository(get()) }
    single<DogsNetworkService> { RetrofitCreator.createService("https://dog.ceo/api/") }
}