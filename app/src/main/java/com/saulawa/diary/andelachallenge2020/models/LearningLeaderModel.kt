package com.saulawa.diary.andelachallenge2020.models

import com.google.gson.annotations.SerializedName

class LearningLeaderModel( @SerializedName("name")
                           var learningleadername: String,
                          @SerializedName("hours")
                          var learningleaderhours:String,
                          var country:String,
                          @SerializedName("badgeUrl")
                          var imgurl:String)