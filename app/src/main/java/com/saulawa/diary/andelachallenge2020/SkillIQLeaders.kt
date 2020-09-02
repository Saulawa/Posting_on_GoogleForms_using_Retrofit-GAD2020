package com.saulawa.diary.andelachallenge2020

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saulawa.diary.andelachallenge2020.models.LearningLeaderModel
import com.saulawa.diary.andelachallenge2020.models.SkillIQLeaderModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A fragment representing a list of Items.
 */
class
SkillIQLeaders : Fragment() {

    private var columnCount = 1

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: SkillIQLeaderRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.skill_i_q_leaders_item_list, container, false)




        recyclerView = view.findViewById(R.id.skillediqrecyclerview)
        recyclerAdapter = SkillIQLeaderRecyclerViewAdapter(view.context)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = recyclerAdapter

        var siqlist = listOf<SkillIQLeaderModel>()

        var retrofit = Retrofit.Builder().
        baseUrl(baseURL).
        addConverterFactory(GsonConverterFactory.create()).
        build()

        var jsonapi = retrofit.create(APIInterfaceGetSIQ::class.java)

        var call = jsonapi.skillediq
        call.enqueue(object: Callback<List<SkillIQLeaderModel>> {
            override fun onFailure(call: Call<List<SkillIQLeaderModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<List<SkillIQLeaderModel>>,
                response: Response<List<SkillIQLeaderModel>>
            ) {

                if(response.body() != null){

                    recyclerAdapter.setskillediqlist(response.body()!!)
                }

            }


        })





        // Set the adapter
//        if (view is RecyclerView) {
//            with(view) {
//                layoutManager = when {
//                    columnCount <= 1 -> LinearLayoutManager(context)
//                    else -> GridLayoutManager(context, columnCount)
//                }
////                adapter = SkillIQLeaderRecyclerViewAdapter(DummyContent.ITEMS)
//            }
//        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            SkillIQLeaders().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}