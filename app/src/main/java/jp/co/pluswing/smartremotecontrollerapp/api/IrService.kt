package jp.co.pluswing.smartremotecontrollerapp.api

import retrofit2.http.GET

interface IrService {
    @GET("/irlist")
    suspend fun list(): Map<String, String>
    

}
