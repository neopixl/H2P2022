package fr.hetic.h2p2022

import android.util.Log

/**
 * Created by Florian ALONSO (Neopixl SA).
 * Copyright © 2019 H2P2022. All rights reserved.
 */



fun test() {
    val month = ""


    Log.d("tag", "$month")

    var pikachu: Pokemon? = Pokemon(name = "Pikachu")
    if (pikachu != null) {
        pikachu.name = "Pikachu2"
    }
    pikachu?.name = "Pikachu2"
    pikachu = Pokemon("pikachu3")
    pikachu = null


    val nameIsPikachu = pikachu?.name == "Pikachu"


    var carapuce = Pokemon(name = "carapuce")
    var carapuce3 = Pokemon(name = "carapuce")
    var carapuce2 = Pokemon(name = "carapuce", level = 3)
    val pokemons = arrayOf(carapuce, pikachu)

    val isSameCarapuce = carapuce == carapuce3


    val ints = arrayOf(1,2,3,4)
    val intsEmpty = emptyArray<Int>()
    val intList = mutableListOf(1,2,3,4)

    ints[0] = 8
    intList.add(123)
    intList.removeAt(0)


    val mapped = ints.map {
        "$it"
    }.filter {
        it == "2"
    }.reduce { acc, s -> s }

    Log.d("tag", "$mapped")






    var i = 1

    // i = 1

    val test1 = ++i

    // test1 =  2
    // i = 2



    val test2 = i++

    // test2 =  2
    // i = 3




    val article1 = Article()
    article1.title = "Test"

    val article2 = Article()
    article2.title = "Test"

    val isSame = article1.title == article2.title
            && article1.content == article2.content







}



data class Pokemon(var name: String, var level: Int = 1)



class Article {

    val defaultId = -1

    var title: String = ""
    var content: String = ""

    val isFilled2: Boolean
     get() = title.length > 0

    fun isFilled() : Boolean {
        return title.length > 0
    }

}
