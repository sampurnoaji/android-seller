package id.io.android.seller.data.source.remote

import id.io.android.seller.data.model.request.user.register.RegisterRequest
import id.io.android.seller.data.model.response.BaseResponse
import id.io.android.seller.data.model.response.user.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @Headers("mock:true")
    @GET("/api/user/{id}")
    suspend fun getUser(@Path("id") id: Int): UserResponse

    @POST("user/register/seller")
    suspend fun register(@Body request: RegisterRequest): BaseResponse
}