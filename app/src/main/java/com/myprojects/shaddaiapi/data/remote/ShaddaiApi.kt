package com.myprojects.shaddaiapi.data.remote

import com.myprojects.shaddaiapi.data.remote.model.CategoryModel
import com.myprojects.shaddaiapi.data.remote.model.ItemProductModel
import com.myprojects.shaddaiapi.data.remote.model.ProductModel
import com.myprojects.shaddaiapi.util.Constants.Companion.CATEGORY_ENDPOINT
import com.myprojects.shaddaiapi.util.Constants.Companion.ID_PRODUCT_ENDPOINT
import com.myprojects.shaddaiapi.util.Constants.Companion.PRODUCT_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ShaddaiApi {

    @GET(PRODUCT_ENDPOINT)
    suspend fun getProducts(): Response<List<ProductModel>>

    @GET(CATEGORY_ENDPOINT)
    suspend fun getCategories() : Response<List<CategoryModel>>

    @GET("$ID_PRODUCT_ENDPOINT{id}")
    suspend fun getProductById(@Path("id")_id: String): Response<ProductModel>


}