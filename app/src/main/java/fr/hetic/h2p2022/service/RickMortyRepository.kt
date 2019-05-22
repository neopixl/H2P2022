package fr.hetic.h2p2022.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Florian ALONSO (Neopixl SA).
 * Copyright © 2019 hetich2p2022. All rights reserved.
 */

class RickMortyRepository {

    val api: RickMortyApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(RickMortyApi::class.java)

    }

}