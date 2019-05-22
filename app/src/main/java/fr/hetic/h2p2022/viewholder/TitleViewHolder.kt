package fr.hetic.h2p2022.viewholder

import android.view.View
import android.widget.TextView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import fr.hetic.h2p2022.R

/**
 * Created by Florian ALONSO (Neopixl SA).
 * Copyright © 2019 hetich2p2022. All rights reserved.
 */

class TitleViewHolder(itemView: View): FastAdapter.ViewHolder<TitleItem>(itemView) {

    val titleTextView: TextView

    init {
        titleTextView = itemView.findViewById(R.id.titleTextView)
    }

    override fun bindView(item: TitleItem, payloads: MutableList<Any>) {
        titleTextView.text = item.title
    }

    override fun unbindView(item: TitleItem) {
        titleTextView.text = ""
    }
}


class TitleItem(val title: String): AbstractItem<TitleItem, TitleViewHolder>() {

    override fun getType() = R.id.item_title

    override fun getViewHolder(v: View) = TitleViewHolder(v)

    override fun getLayoutRes() = R.layout.row_title

    override fun isSelectable() = false

    override fun isEnabled() = false

}