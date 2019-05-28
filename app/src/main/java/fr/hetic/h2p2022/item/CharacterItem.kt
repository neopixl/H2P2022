package fr.hetic.h2p2022.item

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import fr.hetic.h2p2022.R
import fr.hetic.h2p2022.service.Character

/**
 * Created by Florian ALONSO (Neopixl SA).
 * Copyright © 2019 hetich2p2022. All rights reserved.
 */

class CharacterViewHolder(itemView: View) : FastAdapter.ViewHolder<CharacterItem>(itemView) {

    val nameText: TextView
    val statusText: TextView
    val speciesText: TextView
    val logoImage: ImageView

    init {
        nameText = itemView.findViewById(R.id.nameTextView)
        statusText = itemView.findViewById(R.id.statusTextView)
        speciesText = itemView.findViewById(R.id.speciesTextView)
        logoImage = itemView.findViewById(R.id.logoImageView)
    }

    override fun bindView(item: CharacterItem, payloads: MutableList<Any>) {
        nameText.text = item.character.name
        statusText.text = item.character.status
        speciesText.text = item.character.species

        Glide
            .with(logoImage)
            .load(item.character.image)
            .into(logoImage)
    }

    override fun unbindView(item: CharacterItem) {
        nameText.text = ""
        statusText.text = ""
        speciesText.text = ""
        logoImage.setImageBitmap(null)
    }

}

class CharacterItem(val character: Character) : AbstractItem<CharacterItem, CharacterViewHolder>() {

    override fun getType() = R.id.item_character

    override fun getViewHolder(v: View) = CharacterViewHolder(v)

    override fun getLayoutRes() = R.layout.row_character

}