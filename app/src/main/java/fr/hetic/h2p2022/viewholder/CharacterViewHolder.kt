package fr.hetic.h2p2022.viewholder

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

    val nameTextView: TextView
    val statusTextView: TextView
    val speciesTextView: TextView
    val avatarImageView: ImageView

    init {
        nameTextView = itemView.findViewById(R.id.nameTextView)
        statusTextView = itemView.findViewById(R.id.statusTextView)
        speciesTextView = itemView.findViewById(R.id.speciesTextView)
        avatarImageView = itemView.findViewById(R.id.avatarImageView)
    }

    override fun bindView(item: CharacterItem, payloads: MutableList<Any>) {
        nameTextView.text = item.character.name
        statusTextView.text = item.character.status
        speciesTextView.text = item.character.species


        if (item.character.image.isNotEmpty()) {
            Glide
                .with(avatarImageView)
                .load(item.character.image)
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .into(avatarImageView)
        } else {
            avatarImageView.setImageResource(R.drawable.logo)
        }
    }

    override fun unbindView(item: CharacterItem) {
        nameTextView.text = ""
        statusTextView.text = ""
        speciesTextView.text = ""
        avatarImageView.setImageBitmap(null)
    }

}

class CharacterItem(val character: Character): AbstractItem<CharacterItem, CharacterViewHolder>() {

    override fun getType() = R.id.item_character

    override fun getViewHolder(v: View) = CharacterViewHolder(v)

    override fun getLayoutRes() = R.layout.row_character

}