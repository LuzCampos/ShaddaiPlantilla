package com.myprojects.shaddaiapi.repo

import com.myprojects.shaddaiapi.data.remote.RemoteService
import com.myprojects.shaddaiapi.data.remote.model.ItemProductModel
import com.myprojects.shaddaiapi.domain.*
import javax.inject.Inject

class ServiceRepository @Inject constructor(private val remoteService: RemoteService) {
    suspend fun getProducts(): List<ProductItem> {

        return remoteService.getProducts().map {
            it.toProductItem()
        }

    }

    suspend fun getProduct(_id:String): ProductItem {

        return remoteService.getProduct(_id).toProductItem()

    }

    suspend fun getCategories(): List<CategoryItem> {

        return remoteService.getCategories().map {
            it.toCategoryItem()
        }

    }
}