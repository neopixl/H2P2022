package fr.hetic.h2p2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.adapters.ItemAdapter
import fr.hetic.h2p2022.service.CharacterWrapper
import fr.hetic.h2p2022.service.RickMortyRepository
import fr.hetic.h2p2022.viewholder.CharacterItem
import fr.hetic.h2p2022.viewholder.PokemonItem
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_rick_morty.*
import kotlinx.android.synthetic.main.activity_rick_morty.recyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RickMortyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rick_morty)


        recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )

        val itemAdapter = ItemAdapter<CharacterItem>()
        val fastAdapter = FastAdapter.with<CharacterItem, ItemAdapter<CharacterItem>>(itemAdapter)
        recyclerView.adapter = fastAdapter



        itemAdapter.itemFilter.withFilterPredicate { item, constraint ->

            val isOk = item.character.name.equals(constraint)
            isOk
        }

        itemAdapter.filter("Rick")



        val repository = RickMortyRepository()

        repository.api.getAllCharaters()
            .enqueue(object : Callback<CharacterWrapper> {

                override fun onFailure(call: Call<CharacterWrapper>, t: Throwable) {
                    t.printStackTrace()
                    Toast.makeText(this@RickMortyActivity, "ERROR", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<CharacterWrapper>, response: Response<CharacterWrapper>) {
                    val characterWrapper = response.body()
                    if (characterWrapper != null) {


                        for (myCharacter in characterWrapper.results) {
                            if (myCharacter.name.isNotEmpty()) {
                                val item = CharacterItem(myCharacter)

                                itemAdapter.add(item)
                            }
                        }



                    }

                }

            })
    }
}
