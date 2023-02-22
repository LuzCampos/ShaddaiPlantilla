package com.myprojects.shaddaiapi.data.remote

import com.myprojects.shaddaiapi.data.remote.model.ProductModel
import com.myprojects.shaddaiapi.util.Constants.Companion.PRODUCT_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface ShaddaiApi {

    @GET(PRODUCT_ENDPOINT)
    suspend fun getProducts(): Response<List<ProductModel>>
}