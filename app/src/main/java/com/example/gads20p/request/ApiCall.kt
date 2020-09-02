package com.example.gads20p.request

import com.example.gads20p.model.LearningHours
import com.example.gads20p.model.SkillIQ
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiCall {

//  base url https://gadsapi.herokuapp.com/
//  learning hours /api/hours
//  skillIq /api/skilliq


    @GET("api/hours")
    fun getLearningHours() : Call<LearningHours>

    @GET("api/skilliq")
    fun getSkillIQ() : Call<SkillIQ>



    companion object {

        operator fun invoke() : ApiCall {

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://gadsapi.herokuapp.com/")
                .build()
                .create(ApiCall::class.java)
        }

    }
}