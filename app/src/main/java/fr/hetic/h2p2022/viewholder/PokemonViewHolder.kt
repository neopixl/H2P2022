package fr.hetic.h2p2022.viewholder

import android.view.View
import android.widget.TextView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.items.AbstractItem
import fr.hetic.h2p2022.Pokemon
import fr.hetic.h2p2022.R
import kotlinx.android.synthetic.main.row_pokemon.view.*

/**
 * Created by Florian ALONSO (Neopixl SA).
 * Copyright © 2019 hetich2p2022. All rights reserved.
 */


class PokemonViewHolder(itemView: View) : FastAdapter.ViewHolder<PokemonItem>(itemView) {

    val pokemonNameTextView: TextView

    init {
        pokemonNameTextView = itemView.findViewById(R.id.pokemonNameTextView)
    }

    override fun bindView(item: PokemonItem, payloads: MutableList<Any>) {
        pokemonNameTextView.text = item.pokemon.name
    }

    override fun unbindView(item: PokemonItem) {
        pokemonNameTextView.text = ""
    }

}





class PokemonItem(val pokemon: Pokemon) : AbstractItem<PokemonItem, PokemonViewHolder>() {

    override fun getType() = 0

    override fun getViewHolder(v: View) = PokemonViewHolder(v)

    override fun getLayoutRes() = R.layout.row_pokemon

}