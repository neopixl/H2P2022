package fr.hetic.h2p2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import fr.hetic.h2p2022.viewholder.PokemonItem
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
        recyclerView.layoutManager = layout


        val itemAdapter = ItemAdapter<PokemonItem>()
        val fastAdapter = FastAdapter.with<PokemonItem, ItemAdapter<PokemonItem>>(itemAdapter)

        recyclerView.adapter = fastAdapter


        val pikachu = Pokemon("Pikachu")
        val pikachuItem = PokemonItem(pikachu)
        val carapuce = Pokemon("Carapuce")
        val carapuceItem = PokemonItem(carapuce)


        itemAdapter.add(pikachuItem)
        itemAdapter.add(carapuceItem)

        for (i in 0..20000) {

            val pokemon = Pokemon("MY Pokemon $i")
            val pokemonItem = PokemonItem(pokemon)
            itemAdapter.add(pokemonItem)

        }


    }
}
