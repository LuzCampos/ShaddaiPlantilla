package com.myprojects.shaddaiapi.data.remote

import com.myprojects.shaddaiapi.data.remote.model.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteService @Inject constructor(private val shaddaiapi: ShaddaiApi){

    suspend fun getProducts(): List<ProductModel> {

        return withContext(Dispatchers.IO) {
            val products = shaddaiapi.getProducts()
            products.body() ?: emptyList()
        }

    }
}