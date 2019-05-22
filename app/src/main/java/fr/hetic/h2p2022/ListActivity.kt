package fr.hetic.h2p2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.quicksettings.Tile
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.adapters.ItemAdapter
import fr.hetic.h2p2022.item.PokemonItem
import fr.hetic.h2p2022.item.TitleItem
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

        val itemAdapter = ItemAdapter<IItem<*,*>>()
        val fastAdapter = FastAdapter.with<PokemonItem, ItemAdapter<IItem<*,*>>>(itemAdapter)
        fastAdapter.withOnClickListener { view , adapter, item, position ->

            Toast.makeText(this@ListActivity, "POSTION CLICK $position", Toast.LENGTH_SHORT).show()

            true
        }
        recyclerView.adapter = fastAdapter


        val pikachu = Pokemon("Pikachu")
        val pikachuItem = PokemonItem(pikachu)

        val carapuce = Pokemon("Carapuce")
        val carapuceItem = PokemonItem(carapuce)

        itemAdapter.add(pikachuItem)
        itemAdapter.add(carapuceItem)


        for (i in 0..30000) {

            if (i % 10 == 0) {

                val titleItem = TitleItem("HEY YOOO")
                itemAdapter.add(titleItem)

            } else {

                val pokemon = Pokemon("My pokemon $i")
                val item = PokemonItem(pokemon)
                itemAdapter.add(item)
            }
        }



    }
}
