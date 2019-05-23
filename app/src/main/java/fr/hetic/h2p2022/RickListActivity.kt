package fr.hetic.h2p2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.adapters.ItemAdapter
import fr.hetic.h2p2022.item.CharacterItem
import fr.hetic.h2p2022.item.PokemonItem
import fr.hetic.h2p2022.service.Character
import fr.hetic.h2p2022.service.CharacterWrapper
import fr.hetic.h2p2022.service.RickMortyRepository
import kotlinx.android.synthetic.main.activity_rick_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RickListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rick_list)



        recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )


        val itemAdapter = ItemAdapter<IItem<*,*>>()
        val fastAdapter = FastAdapter.with<CharacterItem, ItemAdapter<IItem<*, *>>>(itemAdapter)
        recyclerView.adapter = fastAdapter



        val repository = RickMortyRepository()
        val call = repository.api.getAllCharacter()

        call.enqueue(object: Callback<CharacterWrapper> {

            override fun onFailure(call: Call<CharacterWrapper>, t: Throwable) {
                Toast.makeText(this@RickListActivity, "ERROR", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<CharacterWrapper>, response: Response<CharacterWrapper>) {

                val characterWrapper = response.body()
                if (characterWrapper != null) {

                   for (myCharacter in characterWrapper.results) {

                       val item = CharacterItem(myCharacter)

                       itemAdapter.add(item)
                   }

                }
            }

        })
    }
}
