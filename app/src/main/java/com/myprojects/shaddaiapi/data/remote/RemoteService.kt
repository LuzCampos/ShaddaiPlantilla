package com.myprojects.shaddaiapi.data.remote

import com.myprojects.shaddaiapi.data.remote.model.CategoryModel
import com.myprojects.shaddaiapi.data.remote.model.ItemProductModel
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
    suspend fun getProduct(_id:String): ProductModel {

        return withContext(Dispatchers.IO) {
            val producto = shaddaiapi.getProductById(_id)
            producto.body()!!
        }

    }

    suspend fun getCategories(): List<CategoryModel> {

        return withContext(Dispatchers.IO) {
            val categories = shaddaiapi.getCategories()
            categories.body() ?: emptyList()
        }

    }
}