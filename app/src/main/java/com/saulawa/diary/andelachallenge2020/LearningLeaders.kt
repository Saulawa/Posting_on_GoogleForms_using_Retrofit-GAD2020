package com.saulawa.diary.andelachallenge2020

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saulawa.diary.andelachallenge2020.models.LearningLeaderModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A fragment representing a list of Items.
 */
class LearningLeaders : Fragment() {

    private var columnCount = 1


    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: LearningLRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View? {

        val view = inflater.inflate(R.layout.learning_item_list, container, false)


        recyclerView = view.findViewById(R.id.toplearnerrclist)
        recyclerAdapter = LearningLRecyclerViewAdapter(view.context)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = recyclerAdapter

        var learnerlist = listOf<LearningLeaderModel>()

        var retrofit = Retrofit.Builder().
        baseUrl(baseURL).
        addConverterFactory(GsonConverterFactory.create()).
        build()

        var jsonapi = retrofit.create(ApiInterfaceGetLL::class.java)

        var call = jsonapi.learningleaders
        call.enqueue(object: Callback<List<LearningLeaderModel>> {
            override fun onFailure(call: Call<List<LearningLeaderModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<List<LearningLeaderModel>>,
                response: Response<List<LearningLeaderModel>>
            ) {

                if(response.body() != null){

                    recyclerAdapter.setLearnerlist(response.body()!!)
                }

            }


        })


//        // Set the adapter
//        if (view is RecyclerView) {
//            with(view) {
//                layoutManager = when {
//                    columnCount <= 1 -> LinearLayoutManager(context)
//                    else -> GridLayoutManager(context, columnCount)
//                }
//                adapter = LearningLRecyclerViewAdapter(learnerlist)
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
            LearningLeaders().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }





    }


}