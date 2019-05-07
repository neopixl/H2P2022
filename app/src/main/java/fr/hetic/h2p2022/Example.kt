package fr.hetic.h2p2022

import android.util.Log

/**
 * Created by Florian ALONSO (Neopixl SA).
 * Copyright © 2019 H2P2022. All rights reserved.
 */



fun test() {
    var month = 6
    month = 7

    Log.d("tag", "$month")

    val pokemon: Pokemon? = Pokemon("Pikachu")
    if (pokemon != null) {
        pokemon.name = "Carapuce"
    }
    pokemon?.name = "Carapuce"


    val lenghOfName = pokemon?.name?.length

    Log.d("tag", "$lenghOfName")




    var ints = arrayOf(1,2,3,4,5,6)
    ints[0] = 10
    ints[54] = 10 // Crash !!
    val list = mutableListOf(1,2,3)
    list.add(4)
    list.removeAt(0)
    Log.d("tag", "$ints")


    val mapped = list.map {
        "$it"
    }.filter {
        it == "2"
    }
    Log.d("tag", "$mapped")



    var i = 1

    // i = 1

    val test1 = ++i

    // i = 2
    // test1 = 2

    val test2 = i++

    // i = 3
    // test2 = 2


    val article = Article()
    article.title = "My title"

    val isFilled = article.isFilled()
    val isFilled2 = article.isFilled2

    val article2 = Article2("Title", "")

    val testArticle = Article2("Title", "")

    var isSame = article2.title == testArticle.title


    val pikachu = Pokemon("Pikachu")
    val pikachu2 = pikachu.copy()
    isSame = pikachu == pikachu2





    val values = mutableListOf<Int>(10, 12, 14)

    val valuesOver10Long = values.filter { value -> value>10 }
    val valuesOver10 = values.filter { it>10 }


    val email = "asdasdasdasdasd"
    email.isEmail()

    val test = email containsTest "@"


}


fun String.isEmail(): Boolean {
    return this.contains("@")
}
infix fun String.containsTest(value: String): Boolean {
    return this.contains(value)
}





class Article {

    val defaultId = -1

    var title: String = ""
    var content: String = ""


    val isFilled2: Boolean
    get() = title.isNotBlank()



    fun isFilled(): Boolean {
        return title.isNotBlank()
    }

}

class Article2(val title:String, val subtitle: String) {

}


data class Pokemon(var name: String)




open class Animal {

}

class Dog : Animal() {

}