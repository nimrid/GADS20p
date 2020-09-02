package com.example.gads20p.request

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface FormRequest {

//    google form
//    https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse
//    Entries IDs:
//    Email Address = entry.1824927963
//    Name = entry.1877115667
//    Last Name = entry.2006916086
//    Link to project = entry.284483984


    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitProjectForm(
        @Field("entry.1877115667") firstName : String,
        @Field("entry.2006916086") lastName : String,
        @Field("entry.1824927963") email : String,
        @Field("entry.284483984") linkProject : String
    ) : Call<Void>

    companion object{

        operator fun invoke() : FormRequest {

            return Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .build()
                .create()

        }
    }


}