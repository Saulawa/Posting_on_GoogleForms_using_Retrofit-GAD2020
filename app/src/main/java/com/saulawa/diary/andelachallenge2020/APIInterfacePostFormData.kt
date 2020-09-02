package com.saulawa.diary.andelachallenge2020

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded

import retrofit2.http.POST




interface APIInterfacePostFormData {

    @POST(submissionurl)
    @FormUrlEncoded
    fun postForm(
        @Field("entry.1877115667") firstName: String?,
        @Field("entry.2006916086") lastName: String?,
        @Field("entry.1824927963") emailAddress: String?,
        @Field("entry.284483984") linkToProject: String?

    ): Call<Void?>?
}