package com.example.a20230124_timothyho_nycschools.api

import com.example.a20230124_timothyho_nycschools.model.HighSchool
import com.example.a20230124_timothyho_nycschools.model.SATScore
import retrofit2.Response
import retrofit2.http.GET

interface NYCAPI {
    @GET("s3k6-pzi2.json")
    suspend fun highSchools(): List<HighSchool>

    @GET("f9bf-2cp4.json")
    suspend fun satScores(): List<SATScore>

    //functions are to be used in repository
}