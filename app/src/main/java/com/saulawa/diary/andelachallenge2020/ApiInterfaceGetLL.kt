package com.saulawa.diary.andelachallenge2020

import android.graphics.Movie
import com.saulawa.diary.andelachallenge2020.models.LearningLeaderModel
import retrofit2.Call

import retrofit2.http.GET


interface ApiInterfaceGetLL {
    @get:GET(learningleadersAPI)
    val learningleaders: Call<List<LearningLeaderModel>>
}