package fr.hetic.h2p2022.item

import android.view.View
import android.widget.TextView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import fr.hetic.h2p2022.Pokemon
import fr.hetic.h2p2022.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Florian ALONSO (Neopixl SA).
 * Copyright © 2019 hetich2p2022. All rights reserved.
 */


class PokemonViewHolder(itemView: View) : FastAdapter.ViewHolder<PokemonItem>(itemView) {

    val pokemonName: TextView

    init {
        pokemonName = itemView.findViewById(R.id.pokemonNameTextView)
    }

    override fun bindView(item: PokemonItem, payloads: MutableList<Any>) {
        pokemonName.text = item.pokemon.name
//        GlobalScope.launch {
//            delay(400)
//            pokemonName.text = "${pokemonName.text} LEL"
//        }
    }

    override fun unbindView(item: PokemonItem) {
        pokemonName.text = ""
    }


}

class PokemonItem(val pokemon: Pokemon) : AbstractItem<PokemonItem, PokemonViewHolder>() {

    override fun getType() = 0

    override fun getViewHolder(v: View) = PokemonViewHolder(v)

    override fun getLayoutRes() = R.layout.row_pokemon

}