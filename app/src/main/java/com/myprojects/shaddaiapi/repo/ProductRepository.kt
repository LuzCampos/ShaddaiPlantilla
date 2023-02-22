package com.myprojects.shaddaiapi.repo

import com.myprojects.shaddaiapi.data.remote.RemoteService
import com.myprojects.shaddaiapi.domain.ProductItem
import com.myprojects.shaddaiapi.domain.toProductItem
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productService: RemoteService) {
    suspend fun getProducts(): List<ProductItem> {

        return productService.getProducts().map {
            it.toProductItem()
        }

    }
}