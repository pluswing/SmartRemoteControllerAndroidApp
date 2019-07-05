package jp.co.pluswing.smartremotecontrollerapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

data class Repo(val name: String)

interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>
}
