package fr.hetic.h2p2022.service

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by Florian ALONSO (Neopixl SA).
 * Copyright © 2019 hetich2p2022. All rights reserved.
 */

interface RickMortyApi {

    @GET("character")
    fun getAllCharacter() : Call<CharacterWrapper>

    @GET("character/{myID}")
    fun getCharacterById(@Path("myID") id: Int) : Call<Character>
}

data class Origin(
    val name: String,
    val url: String
)


data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String,
    val origin: Origin
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)

data class CharacterWrapper(
    val info: Info,
    val results: List<Character>
)