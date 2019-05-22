package fr.hetic.h2p2022

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.adapters.ItemAdapter
import fr.hetic.h2p2022.viewholder.PokemonItem
import fr.hetic.h2p2022.viewholder.TitleItem
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        val layout = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
//        val layout = GridLayoutManager(
//            this,
//            3,
//            RecyclerView.VERTICAL,
//            false
//        )
        recyclerView.layoutManager = layout


        val itemAdapter = ItemAdapter<IItem<*, *>>()
        val fastAdapter = FastAdapter.with<PokemonItem, ItemAdapter<IItem<*, *>>>(itemAdapter)
        recyclerView.adapter = fastAdapter

        fastAdapter.withOnClickListener {  view, adapter, item, position ->
            Toast.makeText(this, "CLICK $position", Toast.LENGTH_SHORT).show()
            true
        }


        val pikachu = Pokemon("Pikachu")
        val pikachuItem = PokemonItem(pikachu)
        val carapuce = Pokemon("Carapuce")
        val carapuceItem = PokemonItem(carapuce)


        itemAdapter.add(pikachuItem)
        itemAdapter.add(carapuceItem)

        for (i in 0..20000) {

            if (i % 10 == 0) {

                val titleItem = TitleItem("Title $i")
                itemAdapter.add(titleItem)

            } else {

                val pokemon = Pokemon("MY Pokemon $i")
                val pokemonItem = PokemonItem(pokemon)
                itemAdapter.add(pokemonItem)
            }


        }

    }
}
