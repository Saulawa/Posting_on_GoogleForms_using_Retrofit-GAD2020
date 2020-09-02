package com.saulawa.diary.andelachallenge2020.models

import com.google.gson.annotations.SerializedName

class SkillIQLeaderModel ( @SerializedName("name")
                           var skillediqname: String,
                           @SerializedName("score")
                           var skillediqscore:String,
                           var skillediqcountry:String,
                           @SerializedName("badgeUrl")
                           var skillediqimgurl:String)