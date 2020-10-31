package com.nayantechonoogy.android.networkservice

import com.nayantechonoogy.android.model.response.GithubTrendingResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("search/repositories?q=android%20language:java&sort=stars&order=desc")
    fun getData() : Call<GithubTrendingResponse>
}