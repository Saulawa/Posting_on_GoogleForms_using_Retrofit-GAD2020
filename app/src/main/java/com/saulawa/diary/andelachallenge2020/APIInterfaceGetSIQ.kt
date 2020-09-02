package com.saulawa.diary.andelachallenge2020

import com.saulawa.diary.andelachallenge2020.models.LearningLeaderModel
import com.saulawa.diary.andelachallenge2020.models.SkillIQLeaderModel
import retrofit2.Call
import retrofit2.http.GET


interface APIInterfaceGetSIQ {
    @get:GET(skillIQleadersAPI)
    val skillediq: Call<List<SkillIQLeaderModel>>
}